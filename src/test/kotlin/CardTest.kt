import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CardTest {

    @Test
    fun compareTo() {
        assertEquals(Card(DEUX, TREFLE), Card(DEUX,TREFLE))
        assertNotEquals(Card(DEUX, TREFLE), Card(TROIS, TREFLE))
        assertNotEquals(Card(DEUX, TREFLE), Card(DEUX, PIQUE));
        assertTrue(Card(DEUX, TREFLE).compareTo(Card(DEUX, CARREAU)) == 0)
        assertTrue(Card(DEUX, TREFLE) < (Card(TROIS, TREFLE)))
    }
}