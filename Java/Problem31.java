class Problem31 {

    private static int[] denoms = { 1, 2, 5, 10, 20, 50, 100, 200 };

    public static void main( String[] args ) {
        System.out.println( waysReached( 200, 7 ) );
    }

    private static int waysReached( int amount, int index ) {
        if ( amount == 0 || index == 0 ) {
            return 1;
        }
        int subseqWays = 0;
        for ( int i = 0; i <= amount / denoms[ index ]; i++ ) {
            subseqWays += waysReached( amount - i * denoms[index], index - 1 );
        }
        return subseqWays;
    }
}
