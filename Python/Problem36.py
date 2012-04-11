def main():
    s = 0
    for n in range( 1000000 ):
        if base10palindrome( n ) and base2palindrome( n ):
            s += n
    print( s )

def base10palindrome( n ):
    n = str( n )
    return n[::-1] == n

def base2palindrome( n ):
    n = bin( n )[2:]
    return n[::-1] == n

if __name__ == "__main__":
    main()

