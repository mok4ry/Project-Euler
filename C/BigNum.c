#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

typedef char digit;

typedef struct {
    digit *number;
    int length;
} bignum;

digit char_to_digit( char c ) {
    return c - '0';
}

digit *char_to_digit_arr( char *c_arr, int length ) {
    digit *new_arr = malloc( sizeof(digit) * length );
    int i;
    for ( i = 0; i < length; i++ ) {
        new_arr[i] = char_to_digit( c_arr[i] );
    }
    return new_arr;
}

bignum *make_bignum( char *strnum ) {
    bignum *newnum = malloc( sizeof(bignum) );
    newnum->length = strlen( strnum );
    newnum->number = char_to_digit_arr( strnum, newnum->length );
    return newnum;
}

bignum *make_bignum_with_length( int len ) {
    bignum *newnum = malloc( sizeof(bignum) );
    newnum->length = len;
    newnum->number = malloc( sizeof(digit) * len );
    return newnum;
}

void print_bignum( bignum *n ) {
    int i;
    bool leading_zeroes_gone = false;
    for ( i = 0; i < n->length; i++ ) {
        if ( !leading_zeroes_gone ) {
            if ( n->number[i] != 0 ) {
                leading_zeroes_gone = true;
                printf( "%d", n->number[i] );
            }
        } else {
            printf( "%d", n->number[i] );
        }
    }
    printf( "\n" );
}

bignum *add_bignums( bignum *a, bignum *b ) {
    bignum *newnum = ( a->length > b->length ) ?
        make_bignum_with_length( a->length + 1 ) :
        make_bignum_with_length( b->length + 1 );
    bool carry = false;
    int a_index = a->length - 1, b_index = b->length - 1;
    int num_index = ( a_index > b_index ) ? a_index + 1 : b_index + 1;
    int curr_dig_sum;

    while( a_index >= 0 && b_index >= 0 ) {
        curr_dig_sum = carry ? a->number[a_index] + b->number[b_index] + 1 :
            a->number[a_index] + b->number[b_index];
        carry = curr_dig_sum > 9 ? true : false;
        newnum->number[num_index] = curr_dig_sum % 10;
        a_index--; b_index--; num_index--;
    }
    
    if ( a_index < 0 && b_index >= 0 ) {
        while( b_index >= 0 ) {
            curr_dig_sum = carry ? b->number[b_index] + 1 : b->number[b_index];
            carry = curr_dig_sum > 9 ? true : false;
            newnum->number[num_index] = curr_dig_sum % 10;
            b_index--; num_index--;
        }
    } else if ( b_index < 0 && a_index >= 0 ) {
        while( a_index >= 0 ) {
            curr_dig_sum = carry ? a->number[a_index] + 1 : a->number[a_index];
            carry = curr_dig_sum > 9 ? true : false;
            newnum->number[num_index] = curr_dig_sum % 10;
            a_index--; num_index--;
        }
    }

    return newnum;
}
