#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

#define UP_BOUND (100)

int main() {
    int sum_squares = sum_of_squares_one_to_n( UP_BOUND );
    int square_sum = square_of_sum_one_to_n( UP_BOUND );

    printf("\nThe difference between the square of the sum and the sum of\n");
    printf( "the squares of the first hundred natural numbers is %d\n\n",
        square_sum - sum_squares );

}
