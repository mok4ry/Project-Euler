"""
The Fibonacci sequence is defined by the following recurrence relation:
    F(n) = F(n - 1) + F(n - 2), where F(1) = 1 and F(2) = 1.

Hence, the first 12 terms will be:
    F(1) = 1, F(2) = 1, F(3) = 2, F(4) = 3, F(5) = 5, F(6) = 8, F(7) = 13, 
    F(8) = 21, F(9) = 34, F(10) = 55, F(11) = 89, F(12) = 144

The 12th term, 144, is the first term to contain three digits.

What is the first term of the Fibonacci sequence to contain 1000 digits?
"""
import sys
import time
import numberwork

def main():
    starting_n = 4775
    for i in range( 15 ):
        t0 = time.time()
        numDigits = numberwork.nthFibonacci( starting_n + i, numOfDigits=True )
        elapsedTime = time.time() - t0
        print( str(starting_n + i) +  "th number has ", numDigits, "digits." )
        if numDigits == 1000:
            print( "The first Fibonacci number to have 1000 digits is the " + \
                str( starting_n + i ) + "th term" )
            print( "Calculated in " + str( elapsedTime ) + "s" )
            break

if len( sys.argv ) > 1:
    print( str( sys.argv[1] ) + "th Fibonacci number is", \
        numberwork.nthFibonacci( int( sys.argv[1] ) ), "with", \
        numberwork.nthFibonacci( int( sys.argv[1] ), numOfDigits=True ), \
        "digits" )
else:
    main()
