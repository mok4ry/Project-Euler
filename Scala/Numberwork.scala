package Numberwork

object Numberwork {
  val delta = 0.0005

  def isLychrelNumber( n: Int ): Boolean = {
    def isLychrelNumberRec( n: BigInt, count: Int ): Boolean = {
      val numPlusReverse = n + reverseNum( n )
      if ( count > 49 ) true
      else if ( isPalindrome( numPlusReverse ) ) false
      else isLychrelNumberRec( numPlusReverse, count + 1 )
    }
    isLychrelNumberRec( n, 0 )
  }

  def getPrimesUnder( upperLimit: Int ): List[Int] =
    getPrimesInRange( 2, upperLimit )

  def getPrimesInRange( lowLimit: Int, upLimit: Int ): List[Int] =
    for (
      x <- (lowLimit to upLimit).toList filter (x => x % 2 == 1)
      if isPrime(x)
    ) yield x

  def isPrime( num: BigInt ): Boolean =
    (2 to math.sqrt(num.doubleValue).toInt) forall ( num % _ != 0 )

  def numConcat( a: BigInt, b: BigInt ): BigInt =
    BigInt( a.toString + b.toString )

  def sum( nums: List[Int] ): Int = nums.foldRight(0)( _ + _ )

  def isInteger( num: Double ): Boolean =
    num - num.toInt < delta

  def isTriangularNumber( num: Int ): Boolean = {
    val possibleN = math.sqrt(2 * num).toInt
    return ((possibleN * (possibleN + 1)) / 2) == num
  }

  def isSquareNumber( num: Int ): Boolean = isInteger(math.sqrt(num))

  def isPentagonalNumber( num: Int ): Boolean =
    isSquareNumber(24 * num + 1) && (math.sqrt(24 * num + 1) % 6).toInt == 5

  def isHexagonalNumber( num: Int ): Boolean =
    isInteger((math.sqrt(8 * num + 1) + 1) / 4)

  def isHeptagonalNumber( num: Int ): Boolean =
    isInteger((math.sqrt(40 * num + 9) + 3) / 10)

  def isOctagonalNumber( num: Int ): Boolean =
    isInteger((math.sqrt(3 * num + 1) + 1) / 3)

  def isCyclic( a: Int, b: Int, digits: Int ): Boolean = {
    val base = math.pow(10, digits)
    return a % base == (b / base).toInt
  }

  // digits: digits of each number to use in determining cyclicity
  // e.g. [123, 345, 561], d = 1  ==> true
  //      [123, 345, 561], d = 2  ==> false
  def isCyclicSet( nums: List[Int], digits: Int, wrap: Boolean = true ): Boolean = {
    def isCyclicSetRec( num: Int, nums: List[Int] ): Option[Int] = {
      if (nums.length == 1 && isCyclic(num, nums(0), 2)) return Option(nums(0))
      for (x <- (0 until nums.length)) {
        if (isCyclic(num, nums(x), digits))
          return isCyclicSetRec(nums(x), nums.take(x) ++ nums.drop(x + 1))
      }
      return None
    }
    isCyclicSetRec( nums(0), nums.slice(1, nums.length) ) match {
      case Some(num) => return if (wrap) isCyclic(num, nums(0), 2) else true
      case None => return false
    }
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
