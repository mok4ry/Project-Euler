#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <math.h>

bool is_prime( long int n );
bool iis_palindrome( int n );
int *to_digits( int n );
int number_of_digits( int n );
int round_to_int( double n );
void print_int_array( int *arr, int len );
bool div_from_one_to_n( long int num, int n );

bool is_prime( long int n ) {
    int i;
    for ( i = 2; i < sqrt(n); i++ ) {
        if ( n % i == 0 ) {
            return false;
        }
    }
    return true;
}

bool is_palindrome( int n ) {
    int max_index = number_of_digits(n) - 1;
    int min_index = 0;

    int left_index = min_index;
    int right_index = max_index;
    int *digits = to_digits(n);

    while( digits[left_index] == digits[right_index] &&
            left_index <= max_index && right_index >= min_index ) {
        left_index++;
        right_index--;
    }

    return left_index == max_index + 1 && right_index == min_index - 1;
}

int *to_digits( int n ) {
    int num_digits = number_of_digits(n);
    int *digits_arr = malloc( sizeof(int) * num_digits );
    int current = n;
    int index = 0;
    int curr_divisor;
    while( current != 0 ) {
        curr_divisor = pow( 10, num_digits - index - 1 );
        digits_arr[index] = current / curr_divisor;
        current = current % curr_divisor;
        index++;
    }
    return digits_arr;
}

int number_of_digits( int n ) {
    return log10( n ) + 1;
}

int round_to_int( double n ) {
    return ( n >= 0 ) ? (int) floor( n + 0.5 ) : (int) floor( n - 0.5 );
}

void print_int_array( int *arr, int len ) {
    int i;
    for ( i = 0; i < len; i++ ) {
        printf( "%d ", arr[i] );
    }
}

bool div_from_one_to_n( long int num, int n ) {
    int i;
    for ( i = 2; i <= n; i++ ) {
        if ( num % i != 0 ) {
            return false;
        }
    }
    return true;
}
