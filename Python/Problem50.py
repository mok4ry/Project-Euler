from numberwork import *

MAX_NUM = 20000

def main():
    highest = 0
    prime = 0
    index = 0
    primes = getPrimesInRange( 2, MAX_NUM )
    numPrimes = len(primes)
    for start in range( numPrimes - 1 ):
        for x in range( numPrimes - start ):
            currSum = sum( primes[ start : start + x ] )
            if currSum > 999999:
                break;
            elif x > highest and isPrime( currSum ):
                highest = x
                prime = currSum
             
    print( highest )
    print( prime )

if __name__ == "__main__":
    main()
