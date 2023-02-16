import kotlin.math.pow

class Hand : Comparable<Hand> {
    private val cards = mutableListOf<Card>();
    private val numberOfCardsInHand = 5;
    private var squareHeight = 0;
    private var brelanHeight = 0;
    private var firstPairHeight = 0;
    private var secondPairHeight = 0;
    private var handValue = 0.0;
    private var isFlush = true;
    private var isQuinte = true;

    constructor() {
        while (cards.size < numberOfCardsInHand) {
            val card = Card();
            if (!cards.contains(card))
                cards.add(card);
        }
        initialize();
    }

    constructor(vararg cards: Card) {
        if (cards.size != numberOfCardsInHand)
            throw Exception("Invalid hand");
        for (card in cards) {
            if (this.cards.contains(card))
                throw Exception("Invalid hand");
            this.cards.add(card);
        }
        initialize();
    }

    private fun initialize() {
        cards.sortDescending();
        evaluateHand();
    }

    fun evaluateHand(): Boolean{
        val cardFrequencies = IntArray(15);
        for (cardIndex in 0  until numberOfCardsInHand) {
            val currentCard = cards[cardIndex];
            confirmCombinationOfFiveCards(currentCard, cardIndex);
            cardFrequencies[currentCard.height.second] += 1;
            handValue += currentCard.height.second * 15.0.pow(numberOfCardsInHand - cardIndex);
        }
        for ((cardHeight, frequency) in cardFrequencies.withIndex()){
            detectCombinationOfSameHeightCards(cardHeight, frequency);
        }
        return isQuinte;
    }

    private fun confirmCombinationOfFiveCards(currentCard: Card, cardIndex: Int) {
        if (cardIndex > 0) {
            val previousCard = cards[cardIndex - 1];
            isFlush = confirmFlush(currentCard, previousCard);
            isQuinte = confirmQuinte(currentCard, previousCard);
        }
    }

    private fun confirmFlush(currentCard: Card, previousCard: Card): Boolean {
        return isFlush && currentCard.color == previousCard.color;
    }

    private fun confirmQuinte(currentCard: Card, previousCard: Card): Boolean {
        return isQuinte && currentCard.height.second == previousCard.height.second;
    }

    private fun detectCombinationOfSameHeightCards(cardHeight: Int, frequency: Int) {
        when (frequency) {
            4 -> squareHeight = cardHeight;
            3 -> brelanHeight = cardHeight;
            2 -> pairHeight(cardHeight);
        }
    }

    private fun pairHeight(cardHeight: Int) {
        if (firstPairHeight == 0)
            firstPairHeight = cardHeight;
        else
            secondPairHeight = cardHeight;
    }

    override fun compareTo(other: Hand): Int{
        when {
            isQuinteFlush() -> return  checkQuinteFlush(other);
            isSquare() -> return  checkSquare(other);
            isFull() -> return  checkFull(other);
            isFlush -> return  checkFlush(other);
            isQuinte -> return  checkQuinte(other);
            isBrelan() -> return  checkBrelan(other);
            isTwoPair() -> return  checkTwoPair(other);
            isPair() -> return  checkPair(other);
            else -> return checkHighCard(other);
        }
    }

    private fun isQuinteFlush(): Boolean{
        return isFlush && isQuinte;
    }

    private fun isSquare(): Boolean{
        return squareHeight != 0;
    }

    private fun isFull(): Boolean{
        return isBrelan() && isPair();
    }

    private fun isTwoPair(): Boolean{
        return firstPairHeight != 0 && secondPairHeight != 0;
    }

    private fun isBrelan(): Boolean{
        return brelanHeight != 0;
    }

    private fun isPair(): Boolean{
        return firstPairHeight != 0;
    }

    private fun checkQuinteFlush(other: Hand): Int{
        if (other.isQuinteFlush())
            return compareHandValue(other);
        else
            return 1;
    }

    private fun checkSquare(other: Hand): Int{
        when {
            other.isQuinteFlush() -> return -1;
            other.isSquare() -> return compareSquare(other);
            else -> return 1
        }
    }

    private fun checkFull(other: Hand): Int{
        when {
            other.isQuinteFlush() -> return -1;
            other.isSquare() -> return -1;
            other.isFull() -> return  brelanHeight.compareTo(other.brelanHeight)
            else -> return 1;
        }
    }

    private fun checkFlush(other: Hand): Int{
        when {
            other.isQuinteFlush() -> return -1;
            other.isSquare() -> return  -1;
            other.isFull() -> return  -1;
            other.isFlush -> return compareHandValue(other);
            else -> return 1;
        }
    }

    private fun checkQuinte(other: Hand): Int{
        when {
            other.isQuinteFlush() -> return -1;
            other.isSquare() -> return -1;
            other.isFull() -> return -1;
            other.isFlush -> return -1;
            other.isQuinte -> return compareHandValue(other);
            else -> return 1;
        }
    }

    private fun checkBrelan(other: Hand): Int{
        when {
            other.isQuinteFlush() -> return  -1;
            other.isSquare() -> return -1;
            other.isFull() -> return -1;
            other.isFlush -> return -1;
            other.isQuinte -> return -1;
            other.isBrelan() -> return compareBrelan(other);
            else -> return 1;
        }
    }

    private fun checkTwoPair(other: Hand): Int{
        when {
            other.isQuinteFlush() -> return  -1;
            other.isSquare() -> return -1;
            other.isFull() -> return -1;
            other.isFlush -> return -1;
            other.isQuinte -> return -1;
            other.isBrelan() -> return -1;
            other.isTwoPair() -> return compareTwoPairs(other);
            else -> return 1;
        }
    }

    private fun checkPair(other: Hand): Int{
        when {
            other.isQuinteFlush() -> return  -1;
            other.isSquare() -> return -1;
            other.isFull() -> return -1;
            other.isFlush -> return -1;
            other.isQuinte -> return -1;
            other.isBrelan() -> return -1;
            other.isTwoPair() -> return -1;
            other.isPair() -> return  comparePair(other);
            else -> return 1;
        }
    }

    private fun checkHighCard(other: Hand): Int{
        when {
            other.isQuinteFlush() -> return  -1;
            other.isSquare() -> return -1;
            other.isFull() -> return -1;
            other.isFlush -> return -1;
            other.isQuinte -> return -1;
            other.isBrelan() -> return -1;
            other.isTwoPair() -> return -1;
            other.isPair() -> return -1;
            else -> return compareHandValue(other);
        }
    }

    private fun compareSquare(other: Hand): Int{
        if (squareHeight == other.squareHeight)
            return compareHandValue(other);
        return squareHeight.compareTo(other.squareHeight);
    }

    private fun compareBrelan(other: Hand): Int{
        if (brelanHeight == other.brelanHeight)
            return compareHandValue(other);
        return brelanHeight.compareTo(other.brelanHeight);
    }

    private fun compareTwoPairs(other: Hand): Int{
        if (secondPairHeight != other.secondPairHeight)
            return secondPairHeight;
        if (firstPairHeight == other.firstPairHeight)
            return compareHandValue(other);
        else
            return firstPairHeight.compareTo(other.firstPairHeight);
    }

    private fun comparePair(other: Hand): Int{
        if (firstPairHeight == other.firstPairHeight)
            return compareHandValue(other)
        else
            return firstPairHeight.compareTo(other.firstPairHeight);
    }

    private fun compareHandValue(other: Hand): Int{
        return handValue.compareTo(other.handValue);
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true;
        if (javaClass != other?.javaClass)
            return false
        other as Hand
        return this.compareTo(other) == 0;
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}