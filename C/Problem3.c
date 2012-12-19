#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

int main() {
    long int number = 600851475143L;
    long int highest = 0L;
    long int current = 3L;
    while( current <= number ) {
        if ( isPrime(current) && number % current == 0 ) {
            highest = current;
            number = number / current;
        } else {
            current += 2;
        }
    }

    printf( "The largest prime factor of 600851475143 is %ld\n", highest );
}
