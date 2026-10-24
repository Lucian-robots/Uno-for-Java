import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Uno {
    public ArrayList<unoCards> deck;
    public ArrayList<unoCards> discardPile;
    public ArrayList<unoCards> playerHand;
    public ArrayList<unoCards> computerHand;
    public ArrayList<unoCards> playerCardsAvalible;

    public int players;
    // player turn = -1 for bot and 1 for human player
    public int playerTurn;
    // playerCardsToDraw (pctd)
    public int pctd;
    public String currentColor;
    public String currentValue;
    
    
    // constructor for main() 
    public Uno() {
        this.deck = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.playerHand = new ArrayList<>();
        this.computerHand = new ArrayList<>();
    }



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
    // make shuffled deck thing
    public ArrayList<unoCards> shuffledDeck = shuffleDeck(Deck);
    // draw 1 card
    public unoCards draw1Card(ArrayList<unoCards> shuffledDeck) {
        return shuffledDeck.remove(0);
    }
    // add card to discard pile
    public void/*ArrayList<unoCards>*/ discardPile(unoCards c2) {
        // make discardPile array list
        //ArrayList<unoCards> discardPile = new ArrayList<>();
        // add card to it
        this.discardPile.add(c2);
        // return the discard pile
        //return discardPile;
    }
    // to draw the initial 7 cards
    public ArrayList<unoCards> makeInitialHands(ArrayList<unoCards> shuffledDeck) {
        ArrayList<unoCards> hand = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            hand.add(shuffledDeck.get(0));
            shuffledDeck.remove(0);
        }
        
        return hand;
    }
    // draw 1 card  BROKEN
    public void draw() {
        ArrayList<unoCards> cards = cards();
        ArrayList<unoCards> shuffledDeck = shuffleDeck(cards);
    }   
    // checking if correct color
    public boolean isCorrectColor(unoCards c1) {
        boolean isColor;
        /* 
        if (c1.getColor().equals("Blue") && currentColor == "Blue") {
            isColor = true;
        } 
        */
        if (c1.getColor().equals(currentColor)) {
            isColor = true;
        }
        else {
            isColor = false; 
        }
        return isColor;
        
    }
    // check if player has a card they can play
    public ArrayList<unoCards> cardsToPlay() {
        for (int i = playerHand.size(); i > 0; i--) {
            if (isCorrectColor(playerHand.get(i)) == true) {
                
            }
            else {

            }
            return playerCardsAvalible;
        }
    }
    // play card method, checks card that is played and outputs the result. Updates pct, currentColor, currentValue
    public String playCard(unoCards c1) {
        if (c1.getValue().equals("Reverse")) {
            currentValue = "-1";
            playerTurn = -(playerTurn);         
            return ("Play is reversed!"); 
        }
        else if (c1.getValue().equals("Skip") && isCorrectColor(c1) == true) {
            pctd = 0;
            playerTurn = playerTurn;
            return ("Next player skipped!");
        }
        else if (c1.getValue().equals("")) {
            currentValue = "-1";
            return "Wild card, choose color";

        }
        else if (c1.getValue().equals("Draw 4")) {
            currentValue = "-1";
            pctd +=4;
            for (int i = 0; i < 4; i++) {
                playerHand.add(draw1Card(shuffledDeck));
            }
            return "Draw 4"; 
        }
        else if ((c1.getValue().equals("0") || c1.getValue().equals("1") || c1.getValue().equals("2") || c1.getValue().equals("3") || c1.getValue().equals("4") || c1.getValue().equals("5") || c1.getValue().equals("6") || c1.getValue().equals("7") || c1.getValue().equals("8") || c1.getValue().equals("9")) && isCorrectColor(c1) == true) {
            currentValue = c1.getValue();

            discardPile(c1);     
            playerTurn = -(playerTurn);
            return "Card played, next persons turn";
        }
        else if(!(c1.getColor().equals(currentColor))) {
            if (c1.getValue().equals(currentValue)) {
                currentValue = c1.getValue();
                pctd = 0;
                return "Card played";
            }
            else {

                pctd+=1;
                return "Incorrect color, you have to draw";
            }
        }
        else {
            return "no card was played?";
        }       
    }
    //check output of playCard() and then call the correct method

    // check how many cards the players have to call "Uno!"
    public void checkUno() {
        int player1size = playerHand.size();
        int player2size = computerHand.size();
        if (player2size == 1) {
            System.out.println("Computer Uno");
        }
        if (player1size == 1) {
            System.out.println("Human Uno");
        }
    }


    public String playerChoice(/*ArrayList<unoCards> shuffledDeck, */String choice, unoCards c1) {

        if (choice.equals("draw")) {
            draw1Card(shuffledDeck);
        }
        else if (choice.equals("playcard")) {
            playCard(c1);
        }
        return choice;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    // making update methods so gameDriver isn't a bunch of copying and pasting the same commands
    
    // to check value of card in discard pile
    public void currentDiscardValue() {
        currentValue = discardPile.get(discardPile.size()-1).getValue();    
    }
    public void currentDiscardColor() {
        currentColor = discardPile.get(discardPile.size()-1).getColor();
    }
    public void currentPlayedColor() {
        currentColor = shuffledDeck.get(0).getColor();
    }
    public void currentPlayedValue() {
        currentValue = shuffledDeck.get(0).getValue();
    }

    
    /////////////////////////////////////////////////////////////////////////////////////
      
    public void gameDriver() {
        /* 
        System.out.println(shuffledDeck + "\n");

        ArrayList<unoCards> playerHand = makeInitialHands(shuffledDeck);
        playerHand = makeInitialHands(shuffledDeck);
        playerHand.add(draw1Card(shuffledDeck));

        System.out.println(playerHand);
        System.out.println(shuffledDeck);
        */
        
        playerHand = makeInitialHands(shuffledDeck);
        computerHand = makeInitialHands(shuffledDeck);
        discardPile(shuffledDeck.get(0));
        // the .add function for the discard pile goes in order of when added so we need to access the last added card, not the top card
        currentDiscardColor();
        currentDiscardValue();

        while (!(playerHand.size() == 0 || computerHand.size() == 0)) {
            Scanner input = new Scanner(System.in);
            
            // check who has uno
            checkUno();
            // check if they have to draw
            if (pctd > 0) {
                for (int i = pctd; i > 0; i--) {
                    draw1Card(shuffledDeck);
                }
            } 
            // check if they have a card they can play
            if (canPlay(playerHand.get(0)) == true) {
                System.out.println("What would you like to do: 1. Lay your ");

            }
            else {
                
            }
        }
        
    }

    public static void main(String[] args) {
        // create your game instance
        Uno game = new Uno();   
    
        // call the static method "cards()" to generate a deck
        ArrayList<unoCards> Deck = cards();
    
        // pass that deck into your static method "shuffleDeck()"
        ArrayList<unoCards> shuffledDeck = shuffleDeck(Deck);
    
        // drive the game using the shuffled deck
        game.gameDriver();
    
        // draw 1 card
        //System.out.println(game.draw1Card(shuffledDeck));
    }
}