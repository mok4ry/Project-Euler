#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

#define UP_BOUND_PRIMES (2000000)

int main() {
    printf( "\nThe sum of all primes below two million is %ld\n\n",
        sum_of_primes_under( UP_BOUND_PRIMES ) );
}
