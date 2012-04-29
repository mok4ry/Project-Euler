import java.util.ArrayList;

class numberwork {

    /**
     * Used for covering floating-point discrepancies.
     */
    public static final double DELTA = 0.0000001;

    /**
     * Returns the factorial of a number. Uses only primitive int precision.
     *
     * @param n An integer whose factorial is desired.
     * @return Factorial of the argument.
     */
    public static int factorial( int n ) {
        int product = 1;
        for ( int i = 2; i <= n; i++ ) {
            product *= i;
        }
        return product;
    }

    /**
     * Returns an ArrayList of Integers representing the digits in a number.
     *
     * @param n An integer whose digits are to be gotten.
     * @return ArrayList containing digits of the argument.
     */
    public static ArrayList<Integer> toDigits( int n ) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while ( n != 0 ) {
            digits.add( new Integer( n % 10 ) );
            n = n / 10;
        }
        return digits;
    }

    /**
     * Returns an ArrayList of the first n triangle numbers.
     *
     * @param n Number of triangle numbers to return.
     * @return First n triangle numbers.
     */
    public static ArrayList<Integer> firstNtriNums( int n ) {
        ArrayList<Integer> triNums = new ArrayList<Integer>();
        int lastNum = 0;
        for ( int i = 1; i <= n; i++ ) {
            lastNum += i;
            triNums.add( lastNum );
        }
        return triNums;
    }

    /**
     * Returns true if the given number is a triangle number.
     *
     * @param n The number to check for being triangular.
     * @return true if the given number is a triangle number.
     */
    public static boolean isTriangleNumber( double n ) {
        double root = ( Math.sqrt( 1 + 8*n ) - 1 ) / 2; 
        return Math.abs( root - (int)root ) < DELTA;
    }

    /**
     * Returns true if the given number is a pentagonal number.
     *
     * @param n The number to check for being pentagonal.
     * @return true if the number is a pentagonal number.
     */
    public static boolean isPentagonalNumber( double n ) {
        double root = ( Math.sqrt( 1 + 24*n ) + 1 ) / 6; 
        return Math.abs( root - (int)root ) < DELTA;
    }

    /**
     * Returns true if the given number is a hexagonal number.
     *
     * @param n The number to check for being hexagonal.
     * @return true if the number is a hexagonal number.
     */
    public static boolean isHexagonalNumber( double n ) {
        double root = ( Math.sqrt( 1 + 8*n ) + 1 ) / 4; 
        return Math.abs( root - (int)root ) < DELTA;
    }

    /**
     * Returns the nth triangle number.
     *
     * @param n Indicates the nth triangle number.
     * @return The nth triangle number.
     */
    public static int nthTriangleNumber( int n ) {
        return ( n * ( n + 1 ) )/2;
    }

    /**
     * Returns the nth pentagonal number.
     *
     * @param n Indicates the nth pentagonal number.
     * @return The nth pentagonal number.
     */
    public static int nthPentagonalNumber( int n ) {
        return ( n * ( 3*n - 1 ) )/2;
    }

    /**
     * Returns the nth hexagonal number.
     *
     * @param n Indicates the nth hexagonal number.
     * @return The nth hexagonal number.
     */
    public static int nthHexagonalNumber( int n ) {
        return n * ( 2*n - 1 );
    }
}
