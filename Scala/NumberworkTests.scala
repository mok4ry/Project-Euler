import Numberwork.Numberwork._

object NumberworkTests {

  def main( args: Array[String] ) {
    // asserting framework for easy testing
    def assertEqual( result: Int, expected: Int, msg: String ) = {
      if (result == expected) print(".")
      else println("\nX - " + msg)
    }

    def assertTrue( result: Boolean, msg: String ) = {
      if (result) print(".")
      else println("\nX - " + msg)
    }

    def assertFalse( result: Boolean, msg: String ) = assertTrue(!result, msg)


    // tests for math functions in this object
    assertTrue(isInteger(1.0), "1.0 is an integer")
    assertFalse(isInteger(1.5), "1.5 is not an integer")

    assertTrue(isTriangularNumber(1), "1 is a triangular number")
    assertTrue(isTriangularNumber(10), "10 is a triangular number")
    assertFalse(isTriangularNumber(2), "2 is not a triangular number")

    assertTrue(isSquareNumber(1), "1 is a square number")
    assertTrue(isSquareNumber(9), "9 is a square number")
    assertFalse(isSquareNumber(5), "5 is not a square number")

    assertTrue(isPentagonalNumber(1), "1 is a pentagonal number")
    assertTrue(isPentagonalNumber(12), "12 is a pentagonal number")
    assertFalse(isPentagonalNumber(3), "3 is not a pentagonal number")

    assertTrue(isHexagonalNumber(1), "1 is a hexagonal number")
    assertTrue(isHexagonalNumber(45), "45 is a hexagonal number")
    assertFalse(isHexagonalNumber(3), "3 is not a hexagonal number")

    assertTrue(isHeptagonalNumber(1), "1 is a heptagonal number")
    assertTrue(isHeptagonalNumber(34), "34 is a heptagonal number")
    assertFalse(isHeptagonalNumber(5), "5 is not a heptagonal number")

    assertTrue(isOctagonalNumber(1), "1 is an octagonal number")
    assertTrue(isOctagonalNumber(40), "40 is an octagonal number")
    assertFalse(isOctagonalNumber(5), "5 is not an octagonal number")

    assertTrue(isCyclic(1234, 3456, 2),
        "1234 and 3456 are cyclic (non-wrapping)")
    assertTrue(isCyclic(3456, 5678, 2),
        "3456 and 5678 are cyclic (non-wrapping)")
    assertFalse(isCyclic(1234, 5678, 2),
        "1234 and 5678 are not cyclic (non-wrapping)")

    assertTrue(isCyclicSet(1212 :: 1212 :: Nil, 2),
        "[1212, 1212] is a cyclic set")
    assertTrue(isCyclicSet(1234 :: 3456 :: 5678 :: 7812 :: Nil, 2),
        "[1234, 3456, 5678, 7812] is a cyclic set")
    assertTrue(isCyclicSet(1234 :: 5678 :: 3456 :: 7812 :: Nil, 2),
        "[1234, 5678, 3456, 7812] is a cyclic set")
    assertTrue(isCyclicSet(8128 :: 8281 :: 2882 :: Nil, 2),
        "[8128, 8281, 2882] is a cyclic set")
    assertTrue(isCyclicSet(1234 :: 3456 :: 5678 :: 7890 :: Nil, 2, false),
        "[1234, 3456, 5678, 7890] is a cyclic set (non-wrapping)")
    assertFalse(isCyclicSet(1234 :: 3456 :: 5678 :: 7890 :: Nil, 2),
        "[1234, 3456, 5678, 7890] is not a cyclic set")
    assertFalse(isCyclicSet(1234 :: 5678 :: 9012 :: Nil, 2),
        "[1234, 5678, 9012] is not a cyclic set")

    print("\n")  // newline at end of output because pretty
  }

}