"""
A unit fraction contains 1 in the numerator. The decimal representation of the
unit fractions with denominators 2 to 10 are given:

1/2 = 0.5
1/3 = 0.(3)
1/4 = 0.25
1/5 = 0.2
1/6 = 0.1(6)
1/7 = 0.(142857)
1/8 = 0.125
1/9 = 0.(1)
1/10 = 0.1

Where 0.1(6) means 0.1666666..., and has a 1-digit recurring cycle. It can be
seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle
in its decimal fraction part.
"""
import sys
import time
import numberwork

def main():
    longestPeriod = 1
    number = 0
    for i in range(950, 1000):
        thisLength = numberwork.lengthOfRDR( i )
        if thisLength > longestPeriod:
            longestPeriod = thisLength
            number = i
    print( number, "has the longest reciprocal decimal repetend at", \
        longestPeriod )


if __name__ == "__main__":
    if len( sys.argv ) > 1:
        t0 = time.time()
        print( numberwork.lengthOfRDR( int( sys.argv[1] ) ) )
        print( "Execution time: " + str( time.time() - t0 ) )
    else:
        main()
