'''
numberwork.py - A library of functions dealing with the properties of numbers.
Some special notation:

Author: Matt Mokary (mxm6060@rit.edu)
'''
import decimal
import math

PHI = (1 + math.sqrt(5))/2

def isAbundantNumber(num):
    """ isAbundantNumber: int -> boolean
    An abundant number is a number such that the sum of its proper divisors is
    greater than the number itself.
    Example: 12 -> 1 + 2 + 3 + 4 + 6 = 16
    """
    return sum(getDivisors(num, proper=True)) > num

def isPerfectNumber(num):
    """ isPerfectNumber: int -> boolean
    A perfect number is a number such that the sum of its proper divisors is
    equal to the number itself.
    Example: 6 -> 1 + 2 + 3 = 6
    """
    return sum(getDivisors(num, proper=True)) == num

def isDeficientNumber(num):
    """ isDeficientNumber: int -> boolean
    A deficient number is a number such that the sum of its proper divisors is
    less than the number itself,
    Example: 8 -> 1 + 2 + 4 = 7
    """
    return sum(getDivisors(num, proper=True)) < num

def getDivisors(num, proper=False):
    """ getDivisors: int * boolean -> set
    Returns a number's divisors as a set of integers.
    
    param proper (False by default):
        False; will return all divisors.
        True; will return only proper divisors.

    Proper divisors - all divisors of a number except the number itself.
    """
    if num == 0:
        raise ValueError("Divisors of 0: All real numbers except 0.")
    num = abs(num)
    limit = math.sqrt(num)
    if proper:
        divisors = set()
        divisors.add(1)
        lowerLimit = 2
    else:
        divisors = set()
        lowerLimit = 1
    for divisor in range(lowerLimit, int(limit) + 1):
        if num % divisor == 0:
            divisors.add(divisor)
            divisors.add(num/divisor)

    return divisors

def nthLexicoPerm( objs, n ):
    """ nthLexicoPerm: list * int -> string
    Returns the string representation of the nth lexicographic permutation of
    the passed-in orderable objects.
    """
    if n < 1:
        raise ValueError("Non-positive value of n.")
    n -= 1
    objs = sorted(objs)
    result = ""

    while len( objs ) > 0:
        perms = math.factorial( len( objs ) - 1 )
        if n // perms >= len( objs ):
            raise ValueError("Attempted to get nth permumation of objects "+\
                "with less than n permutations.")
        thisDigit = objs.pop( n // perms )
        result += str( thisDigit )
        n = n % perms
    return result

def nthFibonacci( n, numOfDigits=False ):
    """ nthFibonacci: int -> int
    Returns the nth number in the Fibonacci sequence, defined recursively as:
    F(n) = F(n - 1) + F(n - 2), where F(1) = 1 Aand F(2) = 1 
    """
    if numOfDigits:
        return int ( n * math.log10( PHI ) - math.log10( 5 )/2 ) + 1
    else:
        if n > 1474:
            raise ValueError("Numerical result out of range ( > MAX_INT ).")
        # addition of 0.5 is for rounding purposes using int-casting
        return int ( ( PHI ** n ) / math.sqrt(5) + 0.5 )

def lengthOfRDR( n ):
    """ lengthOfRDR: int -> int
    Returns the length of the longest segment that is repeated in the decimal
    fraction part of a number's reciprocal (reciprocal decimal repetend).
    For example:

    lengthOfRDR( 7 ):
        1/7 = 0.142857142857142857142857...
        = 0.142857 142857 142857 142857 ...
        So the length of the repetend in the decimal fraction part of 7's
        reciprocal is 6.

    - Checks up to 30 places into the decimal part for the beginning of a
        repetend, and for repetends up to length 1000.
    - Will return 1 if the decimal fraction part is terminating.
    """
    decimal.getcontext().prec = 2021
    decString = str( decimal.Decimal(1) / decimal.Decimal( n ) ).split('.')[1]
    foundLength = 1
    for start in range(0, 30):
        for substrlen in range(1, 1000):
            substr = decString[ start : start + substrlen ]
            if substr in decString[ start + substrlen : start + 2 * substrlen ]:
                if substrlen % foundLength == 0 and \
                    not substr[ 0 : foundLength ] in substr[ foundLength : \
                    2 * foundLength ]:
                    foundLength = substrlen
    return foundLength

def getPrimesInRange( lowerLimit, upperLimit ):
    primes = []
    for n in range( lowerLimit, upperLimit + 1 ):
        if isPrime(n):
            primes.append( n )
    return primes

def isPrime( n ):
    """ isPrime: int -> boolean
    Returns True is passed-in number is a prime number,
    returns False is passed-in number is not a prime number.
    """
    n = abs( n )
    if n < 2:
        return False
    limit = math.sqrt( n )

    for divisor in range(2, int(limit) + 1):
        if n % divisor == 0:
            return False

    return True

def spiral( sidelength ):
    """ spiral: int -> 2d array
    Returns a spiral generated by starting with the number 1 and moving right
    in a clockwise direction.

    Example - Spiral with sidelength 5:
        21 22 23 24 25
        20  7  8  9 10
        19  6  1  2 11
        18  5  4  3 12
        17 16 15 14 13

    precondition: sidelength is an odd number (spiral has a center).
    """
    if sidelength % 2 == 0:
        raise ValueError( "numberwork.spiral( sidelength ) called with an " + \
        "even side length: " + str( sidelength ) )
    spiral = [ [0] * sidelength for i in range( sidelength ) ]
    max_buffer = sidelength // 2
    varSidelength = sidelength

    # Upper part
    for buff in range( 0, max_buffer ):
        for x in range( buff, varSidelength + buff ):
            thisVal = varSidelength**2 - varSidelength + x + 1 - buff
            spiral[ buff ][ x ] = thisVal
        varSidelength -= 2

    # center
    spiral[ sidelength // 2 ][ sidelength // 2 ] = 1

    # Lower part
    for buff in range( max_buffer - 1, -1, -1 ):
        varSidelength += 2
        for x in range( buff, varSidelength + buff ):
            thisVal = varSidelength**2 - 2 * varSidelength + 2 - x + buff
            spiral[ sidelength - buff - 1 ][ x ] = thisVal

    # Left part
    varSidelength = sidelength
    for buff in range( 1, max_buffer ):
        for y in range( buff, buff + varSidelength - 1):
            thisVal = varSidelength**2 - varSidelength - y + buff
            spiral[ y ][ buff - 1 ] = thisVal
        varSidelength -= 2

    # Left of center
    spiral[ sidelength // 2 ][ sidelength // 2 - 1] = 6

    # Right of center
    spiral[ sidelength // 2 ][ sidelength // 2 + 1] = 2

    # Right part
    for buff in range ( max_buffer - 1,-1, -1 ):
        for y in range( buff + 1, buff + varSidelength ):
            thisVal = ( varSidelength - 2 )**2 + y - buff
            spiral[ y ][ sidelength - buff - 1] = thisVal
        varSidelength += 2
    
    return spiral

def addToSpiral( sp, sidelength ):
    """ addToSpiral: spiral * int -> spiral
    Adds a layer to the given spiral
    """
    newSidelength = sidelength + 2
    newSpiral = [ [0] for i in range( newSidelength ) ]
    newSpiral[0] = [0] * newSidelength
    newSpiral[ newSidelength - 1 ] = [0] * newSidelength
    for i in range( 1, newSidelength - 1 ):
        newSpiral[i] += sp[i - 1] + [0]
    
    currNum = sidelength ** 2 + 1
    # Right side
    for row in range( newSidelength - 2, -1, -1 ):
        newSpiral[row][newSidelength - 1] = currNum
        currNum += 1
    
    # Top
    for col in range( newSidelength - 2, -1, -1 ):
        newSpiral[0][col] = currNum
        currNum += 1

    # Left side
    for row in range( 1, newSidelength ):
        newSpiral[row][0] = currNum
        currNum += 1

    # Bottom
    for col in range( 1, newSidelength ):
        newSpiral[newSidelength - 1][col] = currNum
        currNum += 1

    return newSpiral

def diagonalsOfSpiral( sidelength ):
    diagNums = []
    baseNum = 0
    for s in range( 1, int( ( sidelength + 1 ) / 2 ) ):
        baseNum = ( 2 * s - 1 ) ** 2
        diagNums.append( baseNum + 2 * s )
        diagNums.append( baseNum + 4 * s )
        diagNums.append( baseNum + 6 * s )
        diagNums.append( baseNum + 8 * s )
    return diagNums

def addToDiagonalsOfSpiral( diagNums, sidelength ):
    diagNums += getAdditionalDiagsOfSpiral( sidelength )
    return diagNums

def getAdditionalDiagsOfSpiral( sidelength ):
    newDiags = []
    distanceFromMiddle = int( ( sidelength + 1 ) / 2 )
    baseNum = (2 * distanceFromMiddle - 1) ** 2
    newDiags.append( baseNum + 2 * distanceFromMiddle )
    newDiags.append( baseNum + 4 * distanceFromMiddle )
    newDiags.append( baseNum + 6 * distanceFromMiddle )
    newDiags.append( baseNum + 8 * distanceFromMiddle )
    return newDiags

def sumOfxPowOfDigits( n, p ):
    """ sumOfxPowOfDigits: int * int -> int
    Returns the sum of each digit of n raised to the pth power.

    - call with p = 1 returns sum of digits of n
    - call with p = 0 returns number of digits of n
    """
    s = 0
    for digit in str( n ):
        s += int( digit ) ** p

    return s
