// The primes 3, 7, 109, and 673, are quite remarkable. By taking any two
// primes and concatenating them in any order the result will always be prime.
// For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of
// these four primes, 792, represents the lowest sum for a set of four primes
// with this property.

// Find the lowest sum for a set of five primes for which any two primes
// concatenate to produce another prime.

import Numberwork.Numberwork._

object Problem60 {
  val MAX_PRIME = 9000
  val primes = getPrimesUnder( MAX_PRIME ).filter( x => x != 2 && x != 5 )
  val numPrimes = primes.length

  def main( args: Array[String] ) {
    for (a <- (2 until numPrimes))
      for (b <- (a + 1 until numPrimes))
        if (bothConcatsArePrime(primes(a), primes(b)))
          for (c <- (b + 1 until numPrimes))
            if (bothConcatsArePrime(primes(a), primes(c)) &&
                bothConcatsArePrime(primes(b), primes(c)))
              for (d <- (c + 1 until numPrimes))
                if (bothConcatsArePrime(primes(a), primes(d)) &&
                    bothConcatsArePrime(primes(b), primes(d)) &&
                    bothConcatsArePrime(primes(c), primes(d)))
                  for (e <- (d + 1 until numPrimes))
                    if (bothConcatsArePrime(primes(a), primes(e)) &&
                        bothConcatsArePrime(primes(b), primes(e)) &&
                        bothConcatsArePrime(primes(c), primes(e)) &&
                        bothConcatsArePrime(primes(d), primes(e))) {
                      println(primes(a) + primes(b) + primes(c) + primes(d) + primes(e))
                      return
                    }
  }

  def numsSatisfyProblem( nums: List[Int] ): Boolean =
    !( ( for {
      i <- ( 0 until nums.length )
      j <- ( i + 1 until nums.length )
    } yield bothConcatsArePrime( nums(i), nums(j) ) ) contains false )

  def bothConcatsArePrime( a: Int, b: Int ): Boolean =
    isPrime( numConcat( a, b ) ) && isPrime( numConcat( b, a ) )

}