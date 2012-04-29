public class Problem46 {

    public static void main( String[] args ) {
        double val = 9;
        while ( true ) {
            if ( !( cbwa( val ) ) ) {
                if ( !( numberwork.isPrime( val ) ) ) {
                    break;
                }
            }
            val += 2;
        }
        System.out.println( "Smallest odd composite number that cannot be " +
            "written as the sum of a prime and twice a square is " + val );
    }

    public static boolean cbwa( double n ) {   // cbwa = can be written as
        int squareroot = (int) Math.sqrt( n / 2 );
        while ( squareroot > 0 ) {
            if ( numberwork.isPrime( n - 2*Math.pow( squareroot , 2 ) ) ) {
                return true;
            }
            squareroot--;
        }
        return false;
    }

}
