def main():
    highestSols = 0
    highestP = 0
    numsToTest = []

    for x in range( 1000 // 12 ):
        numsToTest.append( 12 * x )

    for p in numsToTest:
        sols = 0
        for a in range( 1, p//4 + 1):
            for b in range( a, p//2 + 1):
                c = p - a - b
                if a**2 + b**2 == c**2:
                    sols += 1
                    if sols > highestSols:
                        highestSols = sols
                        highestP = p
                        a = b = p
    print( highestP )

if __name__ == "__main__":
    main()

