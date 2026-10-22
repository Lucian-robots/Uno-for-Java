import java.util.ArrayList;
import java.util.Collections;

public class Uno {
    


    // to make the deck of cards
    public static ArrayList<unoCards> cards() {
    
        ArrayList<unoCards> cards = new ArrayList<>();
        // adding all regular play cards
        for (int i = 1; i < 10; i++) {
            for (int z = 0; z < 2; z++) {
                String value = String.valueOf(i);
                unoCards card1 = new unoCards("Red", value);
                cards.add(card1);
            }
            for (int z = 0; z < 2; z++) {
                String value = String.valueOf(i);
                unoCards card1 = new unoCards("Yellow", value);
                cards.add(card1);
            }
            for (int z = 0; z < 2; z++) {
                String value = String.valueOf(i);
                unoCards card1 = new unoCards("Blue ", value);
                cards.add(card1);
            }
            for (int z = 0; z < 2; z++) {
                String value = String.valueOf(i);
                unoCards card1 = new unoCards("Green", value);
                
                cards.add(card1);
            }
        }
        // going to manually enter these       
        unoCards yellow0 = new unoCards("Yellow", "0");
        unoCards blue0 = new unoCards("Blue", "0");
        unoCards green0 = new unoCards("Green", "0");
        unoCards red0 = new unoCards("Red", "0");
        cards.add(yellow0);
        cards.add(red0);
        cards.add(green0);
        cards.add(blue0);

        int color = 0;
        // this is for reverse, 2 of each color
        // 1 = blue , 2 = red , 3 = yellow , 4 = green
        for (int i = 0; i < 4; i++) {
            if (color == 1) {
                for (int z = 0; z < 2; z++) {
                    unoCards reverse = new unoCards("Blue", "Reverse");
                    cards.add(reverse);
                }  
            }
            else if (color == 2) {
                for (int z = 0; z < 2; z++) {
                    unoCards reverse = new unoCards("Red", "Reverse");
                    cards.add(reverse);
                }
            }
            else if (color == 3) {
                for (int z = 0; z < 2; z++) {
                    unoCards reverse = new unoCards("Yellow", "Reverse");
                    cards.add(reverse);
                }
            }
            else {
                for (int z = 0; z < 2; z++) {
                    unoCards reverse = new unoCards("Green", "Reverse");
                    cards.add(reverse);
                }
            }
            color++;
        }

        // skips, two of each color (same as above tbh)
        color = 1;
        for (int i = 0; i < 4; i++) {
            if (color == 1) {
                for (int z = 0; z < 2; z++) {
                    unoCards skip = new unoCards("Blue", "Skip");
                    cards.add(skip);
                }
            }            
            else if (color == 2) {   
                for (int z = 0; z < 2; z++) {
                    unoCards skip = new unoCards("Red", "Skip");
                    cards.add(skip);
                }
            }
            else if (color == 3) {
                for (int z = 0; z < 2; z++) {
                    unoCards skip = new unoCards("Yellow", "Skip");
                    cards.add(skip);
                }
            }
            else if (color == 4) {
                for (int z = 0; z < 2; z++) {
                    unoCards skip = new unoCards("Green", "Skip");
                    cards.add(skip);
                }
            }
            color++;
        }

        // draw 2 (two per color)
        color = 1;
        for (int i = 0; i < 4; i++) {
            if (color == 1) {
                for (int z = 0; z < 2; z++) {
                    unoCards draw = new unoCards("Blue", "Draw 2");
                    cards.add(draw);
                }
            }            
            else if (color == 2) {   
                for (int z = 0; z < 2; z++) {
                    unoCards draw = new unoCards("Red", "Draw 2");
                    cards.add(draw);
                }
            }
            else if (color == 3) {
                for (int z = 0; z < 2; z++) {
                    unoCards draw = new unoCards("Yellow", "Draw 2");
                    cards.add(draw);
                }
            }
            else if (color == 4) {
                for (int z = 0; z < 2; z++) {
                    unoCards draw = new unoCards("Green", "Draw 2");
                    cards.add(draw);
                }
            }
            color++;
        }
        
        // wild cards
        for (int i = 0; i < 4; i++) {
            unoCards wild = new unoCards("Wild", "");
            cards.add(wild);
        }
        
        // wild draw 4
        for (int i = 0; i < 4; i++) {
            unoCards wild4 = new unoCards("Wild", "Draw 4");
            cards.add(wild4);
        }
        return cards;
    }

    private ArrayList<unoCards> Deck = cards();

    // Now we need to shuffle the cards!!
    public static ArrayList<unoCards> shuffleDeck(ArrayList<unoCards> Deck) {
        
        Collections.shuffle(Deck);
        return Deck;
    }  

    public unoCards draw1Card(ArrayList<unoCards> Deck) {
        // store temp values to draw the card bc return statements are weird
        String c1Color = Deck.get(0).getColor();
        String c1Value = Deck.get(0).getValue();
        // make temp card
        unoCards c1 = new unoCards(c1Color, c1Value);
        // remove the card we created from array
        Deck.remove(Deck.get(0));
        // return the drawn card
        return c1;
    }

    
    // this is to draw the cards
    public ArrayList<unoCards> Uno() {
        // players cards
        ArrayList<unoCards> playerCards = new ArrayList<>();
        // just to use for the shuffle
        ArrayList<unoCards> cards = cards();
        // make the shuffled deck to then draw the cards for the player
        ArrayList<unoCards> shuffledDeck = shuffleDeck(cards);
        //System.out.println(shuffledDeck);
        // draw 7 cards
        for (int i = 0; i < 7; i++) {
            playerCards.add(shuffledDeck.get(i));
        }
        for (int i = 0; i < 7; i++) {
            shuffledDeck.remove(shuffledDeck.get(0));
        }
        //System.out.println("\n\n" + shuffledDeck.size() + "\n\n" + shuffledDeck + "\n\n");
        //System.out.println(playerCards);
        return playerCards;
    }
    public static void draw() {
        ArrayList<unoCards> cards = cards();
        ArrayList<unoCards> shuffledDeck = shuffleDeck(cards);
    }    
}