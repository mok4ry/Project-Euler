#include <stdio.h>
#include <stdlib.h>
#include "Numberwork.c"

#define MIN_NUM (2520) // divisible by 8, must end in 0, so increment by 40
#define UP_BOUND (20)
#define INCREMENT (40)

int main() {
    long int i = MIN_NUM;
    bool found = false;

    while( !found ) {
        if ( div_from_one_to_n( i, UP_BOUND ) ) {
            found = true;
        } else {
            i += INCREMENT;
        }
    }
    printf( "Smallest positive number evenly divisible by 1 to 20 is %ld\n",
        i );
}
