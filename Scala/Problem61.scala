// Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers
// are all figurate (polygonal) numbers and are generated by the following
// formulae:
//
// Triangle     P_3,n = n(n+1)/2    1, 3,  6, 10, 15, ...
// Square       P_4,n = n2          1, 4,  9, 16, 25, ...
// Pentagonal   P_5,n = n(3n−1)/2   1, 5, 12, 22, 35, ...
// Hexagonal    P_6,n = n(2n−1)     1, 6, 15, 28, 45, ...
// Heptagonal   P_7,n = n(5n−3)/2   1, 7, 18, 34, 55, ...
// Octagonal    P_8,n = n(3n−2)     1, 8, 21, 40, 65, ...
//
// The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three
// interesting properties.
//
// The set is cyclic, in that the last two digits of each number is the first
// two digits of the next number (including the last number with the first).
// Each polygonal type: triangle (P_3,127=8128), square (P_4,91=8281), and
// pentagonal (P_5,44=2882), is represented by a different number in the set.
// This is the only set of 4-digit numbers with this property.
// Find the sum of the only ordered set of six cyclic 4-digit numbers for which
// each polygonal type: triangle, square, pentagonal, hexagonal, heptagonal,
// and octagonal, is represented by a different number in the set.

import Numberwork.Numberwork._

object Problem61 {
  val invalidBeginnings = 42 :: 93 :: 38 :: 97 :: 13 :: 34 :: 27 :: 54 :: 98 ::
    66 :: 48 :: 63 :: 72 :: 99 :: 19 :: 79 :: 94 :: 68 :: 83 :: 52 :: 57 ::
    32 :: 18 :: 23 :: 90 :: Nil

  def main( args: Array[String] ) {
    val fourDigitNumbers = (1010 until 10000) filter {x: Int =>
      (x % 100 > 9) && !(invalidBeginnings contains (x/100).toInt)
    }
    val tri = fourDigitNumbers filter (isTriangularNumber(_))
    val sq = fourDigitNumbers filter (isSquareNumber(_))
    val pent = fourDigitNumbers filter (isPentagonalNumber(_))
    val hex = fourDigitNumbers filter (isHexagonalNumber(_))
    val hep = fourDigitNumbers filter (isHeptagonalNumber(_))
    val oct = fourDigitNumbers filter (isOctagonalNumber(_))

    for {
      s   <- sq
      p   <- pent
      hx  <- hex
      hp  <- hep
      o   <- oct
    } {
      if (isCyclicSet(s :: p :: hx :: hp :: o :: Nil, 2, false))
        for (t <- tri) 
          if (isCyclicSet(t :: s :: p :: hx :: hp :: o :: Nil, 2)) {
            println(t + s + p + hx + hp + o)
            return
          }
    }
  }

}