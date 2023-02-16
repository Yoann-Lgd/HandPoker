const val COEUR = "Coeur";
const val PIQUE = "Pique";
const val TREFLE = "Trefle";
const val CARREAU = "Carreau";

val DEUX = Pair("2",2);
val TROIS = Pair("3",3);
val QUATRE = Pair("4",4);
val CINQ = Pair("5",5);
val SIX = Pair("6",6);
val SEPT = Pair("7",7);
val HUIT = Pair("8",8);
val NEUF = Pair("9",9);
val DIX = Pair("10",10);
val VALET = Pair("11",11);
val DAME = Pair("12",12);
val ROI = Pair("13",13);
val AS = Pair("14",14);

object Jeu{
    val colors = arrayOf(COEUR, TREFLE, PIQUE, CARREAU);
    var heights = listOf<Pair<String, Int>>(DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX,
                                            VALET, DAME, ROI, AS)
}