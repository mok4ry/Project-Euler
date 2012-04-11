import java.util.ArrayList;

class Problem33 {

    public static void main( String[] args ) {
        int sumOfFactorions = 0;
        for ( int i = 3; i < 50000; i++ ) {
            if ( isFactorion( i ) ) {
                sumOfFactorions += i;
            }
        }
        System.out.println( sumOfFactorions );
    } 
    
    public static boolean isFactorion( int n ) {
        ArrayList<Integer> digits = numberwork.toDigits( n );
        int sum = 0;
        for ( Integer dig : digits ) {
            sum += numberwork.factorial( dig.intValue() );
        }
        return sum == n;
    }
}
