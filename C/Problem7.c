#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

#define NTH_PRIME (10001)

int main() {
    printf( "\nThe %d prime is: %d\n\n",
        NTH_PRIME, get_nth_prime( NTH_PRIME ) );
}
