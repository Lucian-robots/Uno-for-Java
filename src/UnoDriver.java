import java.util.ArrayList;
import java.util.Collections;

public class UnoDriver {
    public static void Main(String []args) {
        System.out.println("Hello world");

    }
    // shuffle / create deck
     public static ArrayList<unoCards> shuffleDeck(ArrayList<unoCards> cards) {
        
        Collections.shuffle(cards);
        return cards;
    } 

    public static void drawCard() {
        
        ArrayList<unoCards> cards = new ArrayList<>();
        
        for (int i = 0; i < 7; i++) {
            cards.get(i);
        } 
    }
    /*
    unoCards will have an array with all cards and will shuffle the deck.
    Uno.java will have all of the functions related to uno.
    UnoDriver will run the game.
    */
}
 