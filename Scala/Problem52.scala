// It can be seen that the number, 125874, and its double,
// 251748, contain exactly the same digits, but in a different order.

// Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
// contain the same digits.

object Problem52 {
  
  val MIN_NUM = 100000
  val MAX_NUM = 1000000/6
  val UP_TO_N_TIMES = 6

  def main( args: Array[String] ) {
    val results = for (
      x <- ( MIN_NUM to MAX_NUM ).toList
      if sameDigsUpToNTimes( x, UP_TO_N_TIMES )
    ) yield x
    println( results(0) )
  }

  def sameDigsUpToNTimes( num: Int, n: Int ): Boolean =
    containSameDigs( for (
      x <- ( 1 to n ).toList ) yield x * num )

  def containSameDigs( nums: List[Int] ): Boolean = {
    val digits = toSortedIntList( nums(0) )
    nums forall ( toSortedIntList(_) == digits )
  }

  def toSortedIntList( n: Int ): List[Int] = toIntList( n ).sortWith( _ < _ )

  def toIntList( n: Int ): List[Int] =
    n.toString.toList.map( _.toInt - '0'.toInt )

}