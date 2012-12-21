#include <stdlib.h>
#include <stdio.h>

#define MAX_FIB 4000000

int main() {
    int prev_fib = 0;
    int current_fib = 1;
    int temp;
    int sum = 0;

    while( current_fib < MAX_FIB ) {
        if ( current_fib % 2 == 0 ) {
            sum += current_fib;
        }
        temp = current_fib;
        current_fib = prev_fib + current_fib;
        prev_fib = temp;
    }

    printf( "The sum of even Fib nums < 4000000 is %d\n", sum );
}
