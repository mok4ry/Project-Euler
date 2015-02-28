// Cubic Permutations
//
// The cube, 41063625 (345^3), can be permuted to produce two other cubes:
// 56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest
// cube which has exactly three permutations of its digits which are also cube.
//
// Find the smallest cube for which exactly five permutations of its digits are
// cube.

import Numberwork.Numberwork._
import collection.mutable.Map

object Problem62 {
  val bigCubes: Set[BigInt] = (for (x <- (1 to 10000)) yield BigInt(x).pow(3)).toSet
  val numBigCubes = bigCubes.size

  def a( num: Int ): Boolean = true

  def main( args: Array[String] ) {
    val digits: Map[String, Int] = Map[String, Int]().withDefaultValue(0)

    for (x <- bigCubes) {
      digits(getOrderedDigits(x)) += 1

      if (digits.exists(p => p._2 == 5)) {
        val d = digits.find(_._2 == 5).getOrElse((1,1))._1
        println(bigCubes.filter(d == getOrderedDigits(_)).min)
        return
      }
    }
  }

}