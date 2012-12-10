import Numberwork._

object Problem55 {

  def main( args: Array[String] ) {
    val numOfLychrelNums = ( for ( x <- ( 1 until 10000 ).toList )
      yield if ( isLychrelNumber(x) ) 1 ) count ( _ == 1 )
    println( numOfLychrelNums )
  }

}