
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

  @deprecated( "Use Numberwork.sumOfDigits instead.", "Dec. 11, 2012" )
  def digitalSum( n: BigInt ): Int = toIntList( n ).foldLeft(0)( _ + _ )

  def power( a: Int, b: Int ): BigInt =
    ( for ( x <- (1 to b) ) yield a ).foldRight(BigInt(1))( _ * _ )

  def isPalindrome( n: BigInt ): Boolean = n == reverseNum( n )

  def reverseNum( n: BigInt ): BigInt =
    BigInt( toIntList( n ).reverse.map( _.toString ).foldRight("")( _ + _ ) )

  def toIntList( n: BigInt ): List[Int] =
    n.toString.toList.map( _.toInt - '0'.toInt )

  def numOfDigits( n: BigInt ): BigInt = sumOfNthPowersOfDigits( n, 0 )

  def sumOfDigits( n: BigInt ): BigInt = sumOfNthPowersOfDigits( n, 1 )

  def sumOfNthPowersOfDigits( n: BigInt, pow: Int ): BigInt =
    toIntList( n ).map( power( _, pow ) ).foldRight(BigInt(1))( _ + _ )

  def areCoprime( a: BigInt, b: BigInt ): Boolean =
    greatestCommonFactor( a, b ) == 1

  def greatestCommonFactor( a: BigInt, b: BigInt ): BigInt =
    if ( b == 0 ) a else greatestCommonFactor( b, a % b )

  def leastCommonMultiple( a: BigInt, b: BigInt ): BigInt =
    ( a * b ) / greatestCommonFactor( a, b )

  def reduce( a: BigInt, b: BigInt ): ( BigInt, BigInt ) = {
    val gcf = greatestCommonFactor( a, b )
    if ( gcf == 1 ) ( a, b ) else reduce( a / gcf, b / gcf )
  }

  class Rational( num: BigInt, denom: BigInt ) {
    val reduced = reduce( num, denom )
    val numerator = reduced._1
    val denominator = reduced._2

    def + ( that: Rational ): Rational = {
      val lcm = leastCommonMultiple( denominator, that.denominator )
      new Rational( lcm / denominator * numerator +
        lcm / that.denominator * that.numerator, lcm )
    }

    def / ( that: Rational ): Rational =
      new Rational(numerator * that.denominator, denominator * that.numerator)

    override def toString: String = numerator + " / " + denominator

  }

}