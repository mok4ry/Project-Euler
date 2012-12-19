// It is possible to show that the square root of two can be expressed as an
// infinite continued fraction.

// 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

// By expanding this for the first four iterations, we get:

// 1 + 1/2 = 3/2 = 1.5
// 1 + 1/(2 + 1/2) = 7/5 = 1.4
// 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
// 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

// The next three expansions are 99/70, 239/169, and 577/408, but the eighth
// expansion, 1393/985, is the first example where the number of digits in the
// numerator exceeds the number of digits in the denominator.

// In the first one-thousand expansions, how many fractions contain a numerator
// with more digits than denominator?

import Numberwork.Numberwork._
import collection.mutable.HashMap

object Problem57 {
  val one = new Rational( 1, 1 )
  val two = new Rational( 2, 1 )

  val cache = new HashMap[Int, Rational]

  def main( args: Array[String] ) {
    val result = for ( x <- (1 to 1000) )
      yield moreDigsInNum( getNthInterationOfSqrt2( x ) )
    println( result.count( _ == true ) )
  }

  def moreDigsInNum( r: Rational ): Boolean =
    numOfDigits( r.numerator ) > numOfDigits( r.denominator )

  def getNthInterationOfSqrt2( n: Int ): Rational =
    one + one / getNthInterationOfSqrt2Helper( n )

  def getNthInterationOfSqrt2Helper( n: Int ): Rational = {
    if ( n == 1 ) two
    else if ( cache contains (n - 1) ) two + one / cache(n - 1)
    else {
      val result = getNthInterationOfSqrt2Helper( n - 1 )
      cache += n -> ( two + one / result )
      cache(n)
    }
  }

}
