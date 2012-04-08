"""
Surprisingly there are only three numbers that can be written that the sum of
the fourth powers of their digits:
    1634 = 1^4 + 6^4 + 3^4 + 4^4
    8208 = 8^4 + 2^4 + 0^4 + 8^4
    9474 = 9^4 + 4^4 + 7^4 + 4^4

As 1 = 1^4 is not a sum, it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316

Find the sum of all the numbers that can be written as the sum of the fifth
powers of their digits.
"""
from numberwork import sumOfxPowOfDigits

def main():
    POWER = 5
    TEST_UP_TO = 200000
    validNums = []
    for num in range( 10, TEST_UP_TO + 1 ):
        if sumOfxPowOfDigits( num, POWER ) == num:
            validNums.append( num )
    print( "Numbers that can be written as the sum of the fifth powers of" + \
    " their digits:\n       ", validNums )
    print( "Sum of such numbers:", sum( validNums ) )

if __name__ == "__main__":
    main()

