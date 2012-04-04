"""
A permutation is an ordered arrangement of objects. For example, 3124 is one
possible permutation of the digits 1, 2, 3, and 4. If all of the permutations
are listed numerically or alphabetically, we call it lexicographic order. The
lexicographic permutations of 0, 1, and 2 are:
        012 021 102 120 201 210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5,
6, 7, 8, and 9?
"""
import sys
import time
import numberwork

def main():
    t0 = time.time()
    print( numberwork.nthLexicoPerm( [0,1,2,3,4,5,6,7,8,9], 1000000 ) ) 
    print( time.time() - t0 )

if len( sys.argv ) > 1:
    n = int( sys.argv[1] )
    lst = []
    for i in range( 2, len( sys.argv ) ):
        lst.append( int( sys.argv[i] ) )
    print( numberwork.nthLexicoPerm( lst, n ) )
else:
    main()
