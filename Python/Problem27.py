"""
Euler published the remarkable quadratic formula:
                n^2 + n + 41

It turns out that the formula will provide 40 primes for the consecutive values
of n from 0 to 39.

Using computers, the incredible formula n^2 - 79n + 1601 was discovered, which
produces 80 primes for consecutive values of n from 0 to 79. The product of the
coefficients, -79 and 1601, is -126479.

Considering quadratics of the form:
    n^2 + an + b, where |a| < 1000 and |b| < 1000,

Find the product of the coefficients, a and b, for the quadratic expression
that produces the maximum number of primes for consecutive values of n,
starting with n = 0.
"""
import time
from numberwork import isPrime

def main():
    valuesOfB = []
    for x in range( 2, 1000 ):
        if isPrime( x ):
            valuesOfB.append( x )
            valuesOfB.append( -x )

    mostPrimes = 0
    bestA = 0
    bestB = 0
    for a in range( -999, 1000, 2 ):
        for b in valuesOfB:
            n = 0
            while not (n**2 + a*n + b) == 0 and \
                isPrime( n**2 + a*n + b ):
                n += 1
            if n > mostPrimes:
                mostPrimes = n
                bestA = a
                bestB = b
    print( "Quadratic equation n^2 + an + b with |a| < 1000, |b| < 1000 that\n \
    produces the most primes for consecutive values of n, starting at n = 0: ")
    print( "n^2 + (" + str( bestA ) + ")n + (" + str( bestB ) + ") produces " + \
        str( mostPrimes ) + " consecutive primes starting from n = 0. " )
    print( "Product of " + str( bestA ) + " and " + str( bestB ) + " is " + \
        str( bestA * bestB ) )

if __name__ == "__main__":
    main()
