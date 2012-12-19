#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

bool isPrime( long int n ) {
    int i;
    for ( i = 2; i < sqrt(n); i++ ) {
        if ( n % i == 0 ) {
            return false;
        }
    }
    return true;
}

