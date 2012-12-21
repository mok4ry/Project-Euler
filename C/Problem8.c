#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

#define LENGTH_OF_NUM (1000)

void read_number( int *num );

int main() {
    int *num_arr = malloc( sizeof(int) * LENGTH_OF_NUM );
    read_number( num_arr );
    
    int i, curr_product, highest = 0;
    for ( i = 0; i < LENGTH_OF_NUM - 4; i++ ) {
        curr_product = num_arr[i] * num_arr[i + 1] * num_arr[i + 2] *
            num_arr[i + 3] * num_arr[i + 4];
        if ( curr_product > highest ) {
            highest = curr_product;
        }
    }

    printf( "\nThe greatest product of five consecutive digits in the\n" );
    printf( "1000-digit number is: %d\n\n", highest );
}

void read_number( int *num ) {
    int index = 0;
    char in_char;

    while( (in_char = getchar()) != EOF ) {
        num[ index ] = char_to_int( in_char );
        index++;
    }
}
