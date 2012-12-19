#include <stdio.h>
#include <stdlib.h>

int main() {
    int sum = 0;
    int current_num = 1;
    
    while( current_num < 1000 ) {
        if ( current_num % 3 == 0 || current_num % 5 == 0 ) {
            sum += current_num;
        }
        current_num++;
    }

    printf( "The sum of all multiples of 3 or 5 below 1000 is %d\n", sum );
}
