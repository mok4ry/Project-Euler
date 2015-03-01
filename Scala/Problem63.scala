// The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit
// number, 134217728=8^9, is a ninth power.

// How many n-digit positive integers exist which are also an nth power?

import Numberwork.Numberwork._

object Problem63 {

  def main( args: Array[String] ) {
    var count = 0

    for {
      base <- (1 until 10)
      exp  <- (1 until 30)
    } {
      if (numOfDigits(BigInt(base).pow(exp)) == exp) {
        count += 1
      }
    }

    println(count)
  }

}