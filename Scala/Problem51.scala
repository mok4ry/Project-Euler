object Problem51 {
  val positionPerms = List( 
    List(0), List(1), List(0, 1), List(2), List(0, 2), List(1, 2),
    List(0, 1, 2), List(3), List(0, 3), List(1, 3), List(0, 1, 3), List(2, 3),
    List(0, 2, 3), List(1, 2, 3), List(0, 1, 2, 3), List(4), List(0, 4),
    List(1, 4), List(0, 1, 4), List(2, 4), List(0, 2, 4), List(1, 2, 4),
    List(0, 1, 2, 4), List(3, 4), List(0, 3, 4), List(1, 3, 4),
    List(0, 1, 3, 4), List(2, 3, 4), List(0, 2, 3, 4), List(1, 2, 3, 4) )

  val MIN_NUMBER = 100000
  val MAX_NUMBER = 150000

  def main( args: Array[String] ) {
    val results = for {
      x <- getPrimesInRange( MIN_NUMBER, MAX_NUMBER )
      if ( maxSubPrimes(x) == 8 )
    } yield x
    val lowestPrimeInFamily = ( for(
      pos <- positionPerms ) yield primesReplDigs( pos, results(0) )
    ).filter ( _.length == 8 ) (0)(0)
    println( lowestPrimeInFamily )
  }

  def maxSubPrimes( n: Int ): Int =
    ( for ( positions <- positionPerms ) yield numPrimesReplDigs( positions, n )
      ).max

  def numPrimesReplDigs( pos: List[Int], n: Int ): Int =
    primesReplDigs( pos, n ).length

  def primesReplDigs( pos: List[Int], n: Int ): List[Int] = {
    val results = for {
      dig <- (0 to 9).toList
    } yield replacePosWithDigit( pos, dig, n )
    results filter ( isPrime(_) )
  }

  def replacePosWithDigit( positions: List[Int], dig: Int, n: Int ): Int = {
    val digChar = dig.toString
    val nChars = n.toString.toList
    val pos = for (
      x <- ( 0 to 5 ).toList
    ) yield if ( positions contains x ) true else false
    val result = ( for (
      x <- ( 0 to 5 ).toList ) yield if ( pos(x) ) digChar else nChars(x)
    ).foldRight("")( _ + _ ).toInt
    if ( result > MIN_NUMBER ) result else 1 // zeroes added in beginning
  }

  def getPrimesInRange( lowLimit: Int, upLimit: Int ): List[Int] =
    for (
      x <- (lowLimit to upLimit).toList
      if isPrime(x)
    ) yield x

  def isPrime( num: Int ): Boolean =
    if ( num < 2 ) false
    else (2 to math.sqrt(num).toInt) forall ( num % _ != 0 )
}
