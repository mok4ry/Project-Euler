import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Problem42 {

    /**
     * An ArrayList of the first 30 triangle numbers.
     */
    public static ArrayList<Integer> triNums = numberwork.firstNtriNums( 30 );

    /**
     * An ArrayList of words in the Problem42.txt file.
     */
    public static String[] words;

    /**
     * Main method.
     */
    public static void main( String[] args ) {
        readNames();
        System.out.println( triWordCount() );
    }

    /**
     * Reads in names from the Problem42.txt file.
     */
    public static void readNames() {
        try {
            Scanner fileIn = new Scanner( new File( "Problem42.txt" ) );
            String wordString = fileIn.nextLine();
            words = wordString.substring(1, wordString.length() - 1).split("\".\"");
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }
    }

    /**
     * Determines if each word in the words array is a triangle word, and keeps
     * count of how many there are.
     *
     * @return number of triangle words in the words array.
     */
    public static int triWordCount() {
        int count = 0;
        for ( String word : words ) {
            if ( triNums.contains( AlphabetValue.score( word ) ) ) {
                count += 1;
            }
        }
        return count;
    }
}
