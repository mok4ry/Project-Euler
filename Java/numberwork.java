import java.util.ArrayList;

class numberwork {
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

}
