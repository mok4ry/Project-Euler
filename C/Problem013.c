#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"
#include "BigNum.c"

int main() {
    char *in_string;
    bignum *sum = make_bignum_with_length( 0 );

    while( scanf( "%s", in_string ) != EOF ) {
        sum = add_bignums( make_bignum( in_string ), sum );
    }

    print_bignum( sum );
}
