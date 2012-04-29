public class Problem45 {

    public static void main( String[] args ) {
        double hexnum = numberwork.nthHexagonalNumber( 144 );
        double increment = hexnum - numberwork.nthHexagonalNumber( 143 ) + 4;

        while( true ) {
            if ( numberwork.isPentagonalNumber( hexnum ) &&
                 numberwork.isTriangleNumber( hexnum ) ) {
                break;
            }
            hexnum += increment;
            increment += 4;
        }

        System.out.println( "First triangle number after 40755 (285th " +
            "triangle number) that is both pentagonal and hexagonal is " +
            hexnum );
    }

}
