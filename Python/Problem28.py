"""
Starting with the number 1 and moving to the right in a clockwise direction, a
5 by 5 spiral is formed as follows:
            (21) 22 23 24 (25)
             20  (7) 8 (9) 10
             19   6 (1) 2  11
             18  (5) 4 (3) 12
            (17) 16 15 14 (13)

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed
in the same way?
"""
import sys
import time
import loadingbar
from numberwork import spiral

def main():
    LEN_SPIRAL = 1001
    print( "Creating spiral of length " + str( LEN_SPIRAL ) + "... ")
    sp = spiral( LEN_SPIRAL )
    s = 0
    y = 0
    start = 0
    end = LEN_SPIRAL - 1
    print( "Summing spiral diagonals ... " )
    bar = loadingbar.LoadingBar( 0, LEN_SPIRAL )
    while not start == LEN_SPIRAL:
        bar.update( start )
        s += sp[ y ][ start ] + sp[ y ][ end ]
        y += 1
        start += 1
        end -= 1
    print( s - 1 ) # center value (1) is counted twice when start == end == 1

if __name__ == "__main__":
    if len( sys.argv ) > 1:
        size = int( sys.argv[1] )
        sp = spiral( size )
        for x in range( size ):
            print( sp[ x ] )
    else:
        T0 = time.time()
        main()
        print( "Execution time:", time.time() - T0 )
