#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

#define TARGET_SUM (1000)

int main() {
    printf( "\nThe product abc such that a^2 + b^2 = c^2 and \n" );
    printf( "a + b + c = 1000 is %d\n\n", get_answer() );
}

int get_answer() {
    int a, b, c;
    for ( a = 1; a < TARGET_SUM; a++ ) {
        b = 1;
        while( a + b < 1000 ) {
            c = 1000 - a - b;
            if ( is_pythagorean_triplet( a, b, c ) ) {
                return a * b * c;
            }
            b++;
        }
    }
    return 0;
}
