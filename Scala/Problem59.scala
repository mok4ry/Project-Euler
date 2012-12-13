// A modern encryption method is to take a text file, convert the bytes to
// ASCII, then XOR each byte with a given value, taken from a secret key. The
// advantage with the XOR function is that using the same encryption key on
// the cipher text, restores the plain text; for example, 65 XOR 42 = 107,
// then 107 XOR 42 = 65.

// Your task has been made easy, as the encryption key consists of three lower
// case characters. Using cipher1.txt a file containing the encrypted ASCII
// codes, and the knowledge that the plain text must contain common English
// words, decrypt the message and find the sum of the ASCII values in the
// original text.

object Problem59 {
  val commonWords = List( " the ", " be ", " to ", " of ", " and ", " a ",
    " in ", " that ", " have " )
  val alpha = List( 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
  val NUM_OF_COMMON_WORDS = 5

  def main( args: Array[String] ) {
    val file = io.Source.fromFile("Problem59.txt")
    val encrypted = file.getLines.next.split(",").map( _.toInt.toChar ).toList
    file.close
    val decryptions = getDecryptionsWithCommonWords( encrypted )
    println( decryptions(0).toList.map( _.toInt ).foldRight(0)( _ + _ ) )
  }

  def getDecryptionsWithCommonWords( enc: List[Char] ): List[String] =
    getDecryptions( enc ) filter (
      stringContainsCommonWords( _, NUM_OF_COMMON_WORDS ) )

  def stringContainsCommonWords( s: String, n: Int ): Boolean =
    commonWords.count ( s contains _ ) >= n

  def getDecryptions( enc: List[Char] ): List[String] =
    for {
      a <- alpha
      b <- alpha
      c <- alpha } yield decryptWithKey( enc, a :: b  :: c :: Nil )

  def decryptWithKey( enc: List[Char], key: List[Char] ): String =
    ( for ( currIndex <- (0 until enc.length) )
      yield enc( currIndex ) ^ key( currIndex % key.length ) ).map(
        _.toChar ).mkString

}