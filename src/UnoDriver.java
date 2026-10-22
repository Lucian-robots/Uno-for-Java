import java.util.ArrayList;
import java.util.Collections;

public class UnoDriver {

    public static void gameDriver() {
        ArrayList<unoCards> player1 = Uno();
        ArrayList<unoCards> player2 = Uno();
        //ArrayList<unoCards> player3 = drawCards();
        //ArrayList<unoCards> player4 = drawCards();
        
        System.out.println(player1);  
        System.out.println(player2);
        //System.out.println(player3);
        //System.out.println(player4);      
    }


    public static void main(String[] args) {
        ArrayList<unoCards> newCards = cards();
        //System.out.println(newCards);
        //System.out.println("\n\n\n" + shuffleDeck(newCards));
        gameDriver();
    }
}