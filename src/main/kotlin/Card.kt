import Jeu.colors
import Jeu.heights
import kotlin.random.Random;

class Card : Comparable<Card> {
    internal var height : Pair<String, Int>;
    internal var color : String;

    constructor(){
        height = heights.get(Random.nextInt(heights.size))
        color = colors.get(Random.nextInt(colors.size));
    }

    constructor(height: Pair<String, Int>, color : String){
        this.height = height;
        this.color = color;
        if (!heights.contains(height) || !colors.contains(color)) throw Exception("Cards error")
    }

    override fun compareTo(other : Card): Int {
        return height.second.compareTo(other.height.second);
    }

    override fun toString(): String {
        return "${height.first} de $color";
    }

    override fun hashCode(): Int {
        return height.hashCode();
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true;
        if (javaClass != other?.javaClass) return false;

        other as Card

        return isSameCard(other);
    }
    private fun isSameCard(other : Card) = height.second == other.height.second && color == other.color;
}