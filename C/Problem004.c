#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "Numberwork.c"

#define MIN_VAL (100)
#define MAX_VAL (999)

int main() {
    int len, highest = 0;
    int *digits;
    int a = MIN_VAL, b = MIN_VAL;

    while ( a <= MAX_VAL ) {
        b = a;
        while( b <= MAX_VAL ) {
            if ( is_palindrome( a * b ) && a * b > highest ) {
                highest = a * b;
            }
            b++;
        }
        a++;
    }
    
    printf( "The largest palindrome made from the product of two 3-digit " );
    printf( "numbers is %d\n", highest );
}
