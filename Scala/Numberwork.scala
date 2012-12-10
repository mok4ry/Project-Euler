
object Numberwork {

  def isLychrelNumber( n: Int ): Boolean = {
    def isLychrelNumberRec( n: BigInt, count: Int ): Boolean = {
      val numPlusReverse = n + reverseNum( n )
      if ( count > 49 ) true
      else if ( isPalindrome( numPlusReverse ) ) false
      else isLychrelNumberRec( numPlusReverse, count + 1 )
    }
    isLychrelNumberRec( n, 0 )
  }

  def digitalSum( n: BigInt ): Int = toIntList( n ).foldLeft(0)( _ + _ )

  def power( a: Int, b: Int ): BigInt =
    ( for ( x <- (1 to a) ) yield b ).foldRight(BigInt(1))( _ * _ )

  def isPalindrome( n: BigInt ): Boolean = n == reverseNum( n )

  def reverseNum( n: BigInt ): BigInt =
    BigInt( toIntList( n ).reverse.map( _.toString ).foldRight("")( _ + _ ) )

  def toIntList( n: BigInt ): List[Int] =
    n.toString.toList.map( _.toInt - '0'.toInt )

}