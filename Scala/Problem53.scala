object Problem53 {
  
  def main( args: Array[String] ) {
    val results = for { 
      n <- (1 to 100).toList
      r <- (1 to n - 1).toList
      if numCombinations( n, r ) > 1000000 } yield 1
    println( results.foldRight(0)( _ + _ ) )
  }

  def numCombinations( n: Int, r: Int ): BigInt =
    if ( n != r ) factorial(n)/( factorial(r) * factorial(n - r) ) else 1

  def factorial( num: Int ): BigInt =
    ( 1 to num ).toList.map( BigInt(_) ).foldRight(BigInt(1))( _ * _ )

}