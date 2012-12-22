#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

#define UP_BOUND (1000000)

int main() {
    int i, current, highest_num, highest_terms = 0;
    for ( i = 1; i < UP_BOUND; i++ ) {
        current = num_terms_in_collatz( i );
        if ( current > highest_terms ) {
            highest_terms = current;
            highest_num = i;
        }
    }
    printf( "\nThe number below one million with the most terms in its\n" );
    printf( "Collatz sequence is %d\n\n", highest_num );
}
