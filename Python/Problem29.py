"""
"""
import time

def main():
    a_to_the_b = set()
    for a in range(2, 101):
        for b in range(2, 101):
            a_to_the_b.add( a ** b )
    print( len( a_to_the_b ) )

if __name__ == "__main__":
    t0 = time.time()
    main()
    print( "Execution time:", time.time() - t0 )
