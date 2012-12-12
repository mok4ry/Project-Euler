from numberwork import diagonalsOfSpiral
from numberwork import getAdditionalDiagsOfSpiral
from numberwork import isPrime

STARTING_SIDELENGTH = 10001

def main():
    sidelength = STARTING_SIDELENGTH
    pClass = Problem58()
    percent = pClass.percentOfDiagonalsPrime( sidelength )

    while ( percent >= 10 ):
        sidelength += 2
        percent = pClass.percentOfDiagonalsPrime( sidelength )

    print( "Spiral with sidelength " + str( sidelength ) + \
        " is the first to have < 10% primes on diagonals." )

class Problem58:
    __slots__ = ( 'primesInDiag' )

    def __init__( self ):
        self.primesInDiag = 0

    def percentOfDiagonalsPrime( self, sl ):
        self.updateNumOfPrimesOnDiagonals( sl )
        totalDigits = 2 * sl - 1
        return 100 * float(self.primesInDiag) / float(totalDigits)

    def updateNumOfPrimesOnDiagonals( self, sl ):
        if self.primesInDiag == 0:
            for num in diagonalsOfSpiral( sl ):
                if isPrime( num ):
                    self.primesInDiag += 1
        else:
            for num in getAdditionalDiagsOfSpiral( sl ):
                if isPrime( num ):
                    self.primesInDiag += 1

if __name__ == "__main__":
    main()
