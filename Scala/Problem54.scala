// The file, Problem54.txt, contains one-thousand random hands dealt to two
// players.
// Each line of the file contains ten cards (separated by a single space): the
// first five are Player 1's cards and the last five are Player 2's cards.
// You can assume that all hands are valid (no invalid characters or repeated
// cards), each player's hand is in no specific order, and in each hand there
// is a clear winner.

// How many hands does Player 1 win?

// KNOWN BUG: 23456 should be a better straight than A2345

object Suit extends Enumeration {
  type Suit = Value
  val CLUBS, HEARTS, SPADES, DIAMONDS = Value
}

object CardValue {
  type CardValue = Int
  val ACE = 14
  val KING = 13
  val QUEEN = 12
  val JACK = 11
}

object Hand {
  type Hand = Array[Card]
}

object Score {
  type Score = Int
  val ROYAL_FLUSH = 9
  val STRAIGHT_FLUSH = 8
  val FOUR_OF_A_KIND = 7
  val FULL_HOUSE = 6
  val FLUSH = 5
  val STRAIGHT = 4
  val THREE_OF_A_KIND = 3
  val TWO_PAIR = 2
  val ONE_PAIR = 1
  val HIGH_CARD = 0
}

import Suit._
import Score._
import Hand._
import CardValue._

object Problem54 {

  def main( args: Array[String] ) {
    val WIN = 1
    val source = io.Source.fromFile("Problem54.txt")
    val lines = source.getLines
    val numPlayerOneWins = ( for ( line <- lines )
      yield if ( playerOneWinsHand( line ) ) WIN ).count( _ == WIN )
    source.close
    println( numPlayerOneWins )
  }

  def playerOneWinsHand( lineFromFile: String ): Boolean = {
    val playerOneHand = lineFromFile.substring( 0, 14 )
    val playerTwoHand = lineFromFile.substring( 15 )
    firstHandWins( parseHand( playerOneHand ), parseHand( playerTwoHand ) )
  }

  def parseHand( cards: String ): Hand =
    for( cardString <- cards.split(" ") ) yield new Card( cardString )

  def firstHandWins( firstHand: Hand, secondHand: Hand ): Boolean =
    ( new ScoredHand( firstHand ) ) > ( new ScoredHand( secondHand ) )

}

class ScoredHand( h: Hand ) {
  val bestScore = getBestScore
  val kickers = getKickers
  val bestScoreCard = getBestScoreCardValue

  def getBestScore: Score  =
    if (royalFlush) ROYAL_FLUSH
    else if (straightFlush) STRAIGHT_FLUSH
    else if (fourOfAKind) FOUR_OF_A_KIND
    else if (fullHouse) FULL_HOUSE
    else if (flush) FLUSH
    else if (straight) STRAIGHT
    else if (threeOfAKind) THREE_OF_A_KIND
    else if (twoPair) TWO_PAIR
    else if (onePair) ONE_PAIR
    else HIGH_CARD

  def getBestScoreCardValue: CardValue =
    bestScore match {
      case FLUSH | STRAIGHT | STRAIGHT_FLUSH | HIGH_CARD
        => kickers.sortWith ( _ > _ ) (0)
      case ROYAL_FLUSH => ACE
      case FULL_HOUSE => getNumsOfCardsByOccurrence( 3 )(0) * 100 +
          getNumsOfCardsByOccurrence( 2 )(0)
      case FOUR_OF_A_KIND => getNumsOfCardsByOccurrence( 4 )(0)
      case THREE_OF_A_KIND => getNumsOfCardsByOccurrence( 3 )(0)
      case TWO_PAIR => {
        val cardValues = getNumsOfCardsByOccurrence( 2 ) sortWith ( _ > _ )
        cardValues(0) * 100 + cardValues(1)
      }
      case ONE_PAIR => getNumsOfCardsByOccurrence( 2 )(0)
    }

  def getKickers: List[Int] = {
    bestScore match {
      case FLUSH | STRAIGHT | STRAIGHT_FLUSH | FULL_HOUSE | HIGH_CARD
        => ( h map ( _.num ) ).toList
      case FOUR_OF_A_KIND | THREE_OF_A_KIND | TWO_PAIR | ONE_PAIR
        => getNumsOfCardsByOccurrence( 1 )
      case _ => List()  // Royal Flush or invalid
    }
  }

  def getNumsOfCardsByOccurrence( n: Int ): List[Int] = {
    val lengthMap = h groupBy ( _.num )
    ( for ( key <- lengthMap.keySet )
      yield if ( lengthMap(key).length == n )
        key else -1 ).filter(_ != -1 ).toList
  }

  def royalFlush: Boolean = flush && h.forall ( _.num > 9 )

  def straightFlush: Boolean = straight && flush

  def fourOfAKind: Boolean = nOfAKind( 4 )

  def fullHouse: Boolean = onePair && threeOfAKind

  def flush: Boolean = h forall ( _.suit == h(0).suit )

  def straight: Boolean = {
    val sortedHand = h map ( _.num ) sortWith ( _ < _ )
    val resultArray = ( for ( x <- sortedHand )
      yield x - sortedHand(0) )
    resultArray.deep == Array(0,1,2,3,4).deep ||
      resultArray.deep == Array(0,1,2,3,12).deep
  }

  def threeOfAKind: Boolean = nOfAKind( 3 )

  def twoPair: Boolean = getNumsOfCardsByOccurrence( 2 ).length == 2

  def onePair: Boolean = nOfAKind( 2 )

  def nOfAKind( n: Int ): Boolean = {
    val digits = for ( x <- h ) yield x.num
    ( for ( current <- digits )
      yield digits count( _ == current ) ) contains n
  }

  def > ( that: ScoredHand ): Boolean =
    if ( this.bestScore > that.bestScore ) true
    else if ( this.bestScore < that.bestScore ) false
    else if ( this.bestScoreCard > that.bestScoreCard ) true
    else if ( this.bestScoreCard < that.bestScoreCard ) false
    else {
      val sortedThisKickers = this.kickers sortWith ( _ > _ )
      val sortedThatKickers = that.kickers sortWith ( _ > _ )

      // This block takes advantage of the constraint that there will
      // always be a clear winner, since the conditional statement will
      // short-circuit when it finds the clear winner. In a real situation,
      // there could be a tie, in which case this implementation would try
      // to access a non-existent index of one array.
      if ( sortedThisKickers(0) > sortedThatKickers(0) ) true
      else if ( sortedThisKickers(0) < sortedThatKickers(0) ) false
      else if ( sortedThisKickers(1) > sortedThatKickers(1) ) true
      else if ( sortedThisKickers(1) < sortedThatKickers(1) ) false
      else if ( sortedThisKickers(2) > sortedThatKickers(2) ) true
      else if ( sortedThisKickers(2) < sortedThatKickers(2) ) false
      else if ( sortedThisKickers(3) > sortedThatKickers(3) ) true
      else if ( sortedThisKickers(3) < sortedThatKickers(3) ) false
      else if ( sortedThisKickers(4) > sortedThatKickers(4) ) true
      else /* if ( sortedThisKickers(4) < sortedThatKickers(4) ) */ false
    }

  def < ( that: ScoredHand ): Boolean = ! ( this > that )

  override def toString: String = bestScore.toString

}

class Card( card: String ) {
  val num = parseNum( card(0) )
  val suit = parseSuit( card(1) )

  def parseNum( n: Char ): CardValue =
    if ( List('A','K','Q','J','T' ) contains n ) n match {
      case 'A' => ACE
      case 'K' => KING
      case 'Q' => QUEEN
      case 'J' => JACK
      case 'T' => 10
    } else n.toInt - '0'.toInt

  def parseSuit( s: Char ): Suit =
    s match {
      case 'C' => CLUBS
      case 'H' => HEARTS
      case 'S' => SPADES
      case 'D' => DIAMONDS
    }

  override def toString: String = num + " " + suit

}