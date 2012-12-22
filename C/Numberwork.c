#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <math.h>

bool is_prime( long int n ) {
    int i;
    for ( i = 2; i <= sqrt(n); i++ ) {
        if ( n % i == 0 ) {
            return false;
        }
    }
    return true;
}

int *to_digits( int n ) {
    int num_digits = number_of_digits(n);
    int *digits_arr = malloc( sizeof(int) * num_digits );
    int current = n;
    int index = 0;
    int curr_divisor;
    while( current != 0 ) {
        curr_divisor = pow( 10, num_digits - index - 1 );
        digits_arr[index] = current / curr_divisor;
        current = current % curr_divisor;
        index++;
    }
    return digits_arr;
}

bool is_palindrome( int n ) {
    int max_index = number_of_digits(n) - 1;
    int min_index = 0;

    int left_index = min_index;
    int right_index = max_index;
    int *digits = to_digits(n);

    while( digits[left_index] == digits[right_index] &&
            left_index <= max_index && right_index >= min_index ) {
        left_index++;
        right_index--;
    }

    return left_index == max_index + 1 && right_index == min_index - 1;
}

int number_of_digits( int n ) {
    return log10( n ) + 1;
}

int round_to_int( double n ) {
    return ( n >= 0 ) ? (int) floor( n + 0.5 ) : (int) floor( n - 0.5 );
}

void print_int_array( int *arr, int len ) {
    int i;
    printf( "[ " );
    for ( i = 0; i < len - 1; i++ ) {
        printf( "%d, ", arr[i] );
    }
    printf( "%d ]\n", arr[ len - 1 ] );
}

bool div_from_one_to_n( long int num, int n ) {
    int i;
    for ( i = 2; i <= n; i++ ) {
        if ( num % i != 0 ) {
            return false;
        }
    }
    return true;
}

int sum_of_squares_one_to_n( int n ) {
    int i, sum = 1;
    for ( i = 2; i <= n; i++ ) {
        sum += i*i;
    }
    return sum;
}

int square_of_sum_one_to_n( int n ) {
    int i, sum = 0;
    for ( i = 1; i <= n; i++ ) {
        sum += i;
    }
    return sum*sum;
}

int get_nth_prime( int n ) {
    int i = 1;      // start at 3
    n--;            // 2 is prime
    while( n > 0 ) {
        i += 2;
        if ( is_prime( i ) ) {
            n--;
        }
    }
    return i;
}

int char_to_int( char c ) {
    return c - '0';
}

bool is_pythagorean_triplet( int a, int b, int c ) {
    return a * a + b * b == c * c;
}

long int sum_of_primes_under( int n ) {
    long int sum = 2;
    int i;
    for ( i = 3; i < n; i += 2 ) {
        if ( is_prime( i ) ) {
            sum += i;
        }
    }
    return sum;
}

int char_array_to_int( char *arr, int length ) {
    int number = 0;
    int index = 0;
    while( index < length ) {
        number += char_to_int( arr[index] ) * pow( 10, length - index - 1);
        index++;
    }
    return number;
}

int get_num_of_divisors( int n ) {
    int num_divs = ( n == 1 ) ? 1 : 2;   // 1 and n
    int i;

    for ( i = 2; i < sqrt(n); i++ ) {
        if ( n % i == 0 ) {
            num_divs += 2;
        }
    }
    if ( n % (int)sqrt(n) == 0 ) {
        num_divs++;
    }
    return num_divs;
}

int num_terms_in_collatz( unsigned long int n ) {
    int count = 1;
    while( n != 1 ) {
        if ( n % 2 == 0 ) {
            n = n / 2;
        } else {
            n = 3*n + 1;
        }
        count++;
    }
    return count;
}

