#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

int main() {
    int triangle_num = 1;
    int increment = 2;
    while( get_num_of_divisors( triangle_num ) <= 500 ) {
        triangle_num += increment;
        increment++;
    }

    printf( "\nThe first triangle number with over 500 divisors is %d\n\n",
        triangle_num );
}
