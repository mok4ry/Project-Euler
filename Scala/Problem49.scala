// Project Euler, Problem 49
//
// The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
// increases by 3330, is unusual in two ways: (i) each of the three terms
// are prime, and, (ii) each of the 4-digit numbers are permutations of one
// another.

// There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
// exhibiting this property, but there is one other 4-digit increasing sequence.

// What 12-digit number do you form by concatenating the three terms in this
// sequence?

object Problem49 {
  
  def main( args: Array[String] ) {
    val given_sequence = "148748178147"
    val results = for { 
      x <- getPrimesInRange( 1000, 10000 )
      increment <- ( 1 to 2000 ) map { _ * 2 }
      if fulfillsRequirements( x, increment )
    } yield List( x, x + increment, x + 2 * increment )
    val resultStrings = for ( x <- results ) yield
      ( x map { _.toString } ).foldRight(""){ (a,b) => a + b }
    for ( x <- resultStrings ) if ( x != given_sequence ) println( x )
  }

  // Precondition: num is prime
  def fulfillsRequirements( num: Int, increment: Int ): Boolean = {
    val secondNum = num + increment
    val thirdNum = num + 2 * increment
    isPrime( secondNum ) && isPrime( thirdNum ) &&
      areAnagrams( num, secondNum, thirdNum )
  }

  def areAnagrams( num1: Int, num2: Int, num3: Int ): Boolean = {
    val num1ordered = orderedDigits( num1 )
    val num2ordered = orderedDigits( num2 )
    val num3ordered = orderedDigits( num3 )
    num1ordered == num2ordered && num1ordered == num3ordered
  }

  def orderedDigits( number: Int ): List[Int] =
    number.toString.map{ c => c.asDigit }.toList.sortWith( _ < _ )

  def getPrimesInRange( lowLimit: Int, upLimit: Int ): List[Int] =
    for (
      x <- (lowLimit to upLimit).toList
      if isPrime(x)
    ) yield x

  def isPrime( num: Int ): Boolean =
    (2 to math.sqrt(num).toInt) forall ( num % _ != 0 )

}
