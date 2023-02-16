import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HandTest{
    var highQuinteFlushPique = Hand(Card(AS, PIQUE), Card(ROI, PIQUE), Card(DAME, PIQUE), Card(VALET, PIQUE), Card(DIX, PIQUE));
    var highQuinteFlushCoeur = Hand(Card(AS, COEUR), Card(ROI, COEUR), Card(DAME, COEUR), Card(VALET, COEUR), Card(DIX, COEUR));
    var lowQuinteFlushPique = Hand(Card(DEUX, PIQUE), Card(TROIS, PIQUE), Card(QUATRE, PIQUE), Card(CINQ, PIQUE), Card(SIX, PIQUE))

    var highSquare = Hand(Card(AS, COEUR), Card(AS, TREFLE), Card(AS, CARREAU), Card(AS, PIQUE), Card(ROI, PIQUE));
    var highSquareTwo = Hand(Card(AS, COEUR), Card(AS, TREFLE), Card(AS, CARREAU), Card(AS, PIQUE), Card(DEUX, COEUR));
    var lowSquare = Hand(Card(DEUX, PIQUE), Card(QUATRE, PIQUE), Card(QUATRE, CARREAU), Card(QUATRE, TREFLE), Card(QUATRE, COEUR));

    var highFull = Hand(Card(AS, COEUR), Card(AS, TREFLE), Card(AS, CARREAU), Card(ROI, PIQUE), Card(ROI, TREFLE));
    var lowFull = Hand(Card(AS, COEUR), Card(AS, TREFLE), Card(AS, CARREAU), Card(DEUX, PIQUE), Card(DEUX, TREFLE));

    var highFlushPique = Hand(Card(AS, PIQUE), Card(ROI, PIQUE), Card(DAME, PIQUE), Card(VALET, PIQUE), Card(NEUF, PIQUE));
    var highFlushTrefle = Hand(Card(AS, TREFLE), Card(ROI, TREFLE), Card(DAME, TREFLE), Card(VALET, TREFLE), Card(NEUF, TREFLE));
    var mediumFlush = Hand(Card(AS, PIQUE), Card(ROI, PIQUE), Card(DAME, CARREAU), Card(DIX, TREFLE), Card(NEUF, COEUR));
    var lowFlush = Hand(Card(HUIT, COEUR), Card(TROIS, COEUR), Card(QUATRE, COEUR), Card(CINQ, TREFLE), Card(DEUX, COEUR));

    var highQuinte = Hand(Card(AS, PIQUE), Card(ROI, PIQUE), Card(DAME, TREFLE), Card(VALET, TREFLE), Card(DIX, COEUR));
    var lowQuinte = Hand(Card(DEUX, TREFLE), Card(TROIS, TREFLE), Card(QUATRE, PIQUE), Card(CINQ, PIQUE), Card(SIX, PIQUE));

    var highBrelan = Hand(Card(VALET, PIQUE), Card(VALET, TREFLE), Card(VALET, CARREAU), Card(DIX, TREFLE), Card(NEUF, COEUR));
    var highBrelanTwo = Hand(Card(VALET, PIQUE), Card(VALET, TREFLE), Card(VALET, CARREAU), Card(DIX, COEUR), Card(NEUF, CARREAU));
    var lowBrelan = Hand(Card(AS, COEUR), Card(ROI, TREFLE), Card(QUATRE, PIQUE), Card(QUATRE, TREFLE), Card(QUATRE, CARREAU));

    var veryHighTwoPair = Hand(Card(AS, PIQUE), Card(AS, TREFLE), Card(ROI, CARREAU), Card(ROI, TREFLE), Card(NEUF, COEUR));
    var highTwoPair = Hand(Card(AS, PIQUE), Card(AS, TREFLE), Card(ROI, CARREAU), Card(ROI, TREFLE), Card(DIX, COEUR));
    var mediumTwoPair = Hand(Card(AS, PIQUE), Card(AS, TREFLE), Card(VALET, PIQUE), Card(VALET, TREFLE), Card(SIX, PIQUE));
    var lowTwoPair = Hand(Card(DEUX, TREFLE), Card(DEUX, PIQUE), Card(QUATRE, PIQUE), Card(QUATRE, TREFLE), Card(SIX, PIQUE));

    var veryHighPair = Hand(Card(AS, PIQUE), Card(AS, TREFLE), Card(ROI, CARREAU), Card(DAME, TREFLE), Card(VALET, COEUR));
    var highPair = Hand(Card(AS, PIQUE), Card(AS, TREFLE), Card(DEUX, TREFLE), Card(TROIS, TREFLE), Card(QUATRE, COEUR));
    var lowPair = Hand(Card(CINQ, TREFLE), Card(CINQ, PIQUE), Card(QUATRE, PIQUE), Card(DEUX, TREFLE), Card(SIX, PIQUE));

    var veryHigh = Hand(Card(AS, COEUR), Card(ROI, TREFLE), Card(DAME, CARREAU), Card(VALET, TREFLE), Card(DIX, COEUR));
    var high = Hand(Card(AS, COEUR), Card(ROI, TREFLE), Card(VALET, CARREAU), Card(DIX, PIQUE), Card(NEUF, COEUR));
    var mediumAs = Hand(Card(AS, CARREAU), Card(CINQ, PIQUE), Card(QUATRE, CARREAU), Card(SIX, PIQUE), Card(SEPT, COEUR));
    var mediumRoi = Hand(Card(ROI, COEUR), Card(DAME, TREFLE), Card(VALET, COEUR), Card(DIX, CARREAU), Card(NEUF, PIQUE));
    var low = Hand(Card(DEUX, COEUR), Card(TROIS, TREFLE), Card(QUATRE, PIQUE), Card(CINQ, CARREAU), Card(SIX, PIQUE));

    @Test
    fun testQuinteFlush(){
        assertTrue(highQuinteFlushCoeur == highQuinteFlushPique);
        assertTrue(highQuinteFlushCoeur > lowQuinteFlushPique);
        assertTrue(lowQuinteFlushPique > highQuinte);
        println(highFlushPique.evaluateHand());
/*        assertTrue(lowQuinteFlushPique > highSquare);*/
/*        assertTrue(lowQuinteFlushPique > veryHighTwoPair);
        assertTrue(lowQuinteFlushPique > highFull);
        assertTrue(lowQuinteFlushPique > highFlushPique);
        assertTrue(lowQuinteFlushPique > highBrelan);
        assertTrue(lowQuinteFlushPique > veryHighTwoPair);
        assertTrue(lowQuinteFlushPique > veryHighPair);
        assertTrue(lowQuinteFlushPique > veryHigh);
        assertTrue(lowQuinteFlushPique < highQuinteFlushPique);*/
    }
}