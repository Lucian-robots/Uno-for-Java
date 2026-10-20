import java.util.ArrayList;

public class Uno {
     public static void unoCards() {
    
        ArrayList<unoCards> cards = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (int z = 0; z < 2; z++) {
                String value = String.valueOf(i);
                unoCards card1 = new unoCards("Red", value);
                cards.add(card1);
            }

        }
        System.out.println(cards);
       
    }
    public static void main(String[] args) {
        unoCards();
    }
}
