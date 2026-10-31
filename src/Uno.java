import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Uno {
    public ArrayList<unoCards> deck;
    public ArrayList<unoCards> discardPile;
    public ArrayList<unoCards> playerHand;
    public ArrayList<unoCards> computerHand;
    public ArrayList<unoCards> playerCardsAvalible = new ArrayList<>();
    public ArrayList<unoCards> computerCardsAvalible = new ArrayList<>();

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
    public void draw1Card() {      
        unoCards c1 = new unoCards(shuffledDeck.get(0).getColor(), shuffledDeck.get(0).getValue());
        playerHand.add(c1);
        shuffledDeck.remove(0);
    }
    // add card to discard pile
    public void/*ArrayList<unoCards>*/ discardPile(unoCards c2) {      
        this.discardPile.add(c2);
        shuffledDeck.remove(c2);
        // return the discard pile
        //return discardPile;
    }
    // to draw the initial 7 cards
    public ArrayList<unoCards> makeInitialHands() {
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
        if (c1.getColor().equals(currentColor)) {
            isColor = true;
        }
        else {
            isColor = false; 
        }
        return isColor;
        
    }
    public boolean isCorrectValue(unoCards c1) {
        boolean isValue;
        if (c1.getValue().equals(currentValue)) {
            isValue = true;
        } 
        else {
            isValue = false;
        }
        return isValue;
    }
    // check if player has a card they can play
    public ArrayList<unoCards> cardsToPlay() {
        for (int i = playerHand.size(); i > 0; i--) {
            if (isCorrectColor(playerHand.get(i)) == true) {
                playerCardsAvalible.add(playerHand.get(i));
            }
            else if (isCorrectValue(playerHand.get(i)) == true) {
                playerCardsAvalible.add(playerHand.get(i));
            }
            else if (playerHand.get(i).getValue().equals("Draw 4") || playerHand.get(i).getValue().equals("")) {
                playerCardsAvalible.add(playerHand.get(i));
            }
        }
        return playerCardsAvalible;
    }
    // play card method, checks card that is played and outputs the result. Updates pct, currentColor, currentValue
    public String playCard(unoCards c1) {
        if (c1.getValue().equals("Reverse")) {
            //currentValue = "Reverse";
            playerTurn = -(playerTurn);
            currentColor = c1.getColor();
            currentValue = c1.getValue();
            playerHand.remove(c1);
            playerCardsAvalible.remove(c1);
            return ("Play is reversed!"); 

        }
        else if (c1.getValue().equals("Skip") && isCorrectColor(c1) == true) {
            pctd = 0;
            playerTurn = playerTurn;
            currentColor = c1.getColor();
            currentValue = c1.getValue();
            playerHand.remove(c1);
            playerCardsAvalible.remove(c1);
            return ("Next player skipped!");
        }
        else if (c1.getValue().equals("")) {
            currentValue = "-1";
            currentColor = c1.getColor();
            currentValue = c1.getValue();
            playerHand.remove(c1);
            playerCardsAvalible.remove(c1);
            return "Wild card, choose color";

        }
        else if (c1.getValue().equals("Draw 4")) {
            currentValue = "-1";
            pctd +=4;
            currentColor = c1.getColor();
            currentValue = c1.getValue();
            playerHand.remove(c1);
            playerCardsAvalible.remove(c1);
            for (int i = 0; i < 4; i++) {
                draw1Card();
            }
            return "Draw 4"; 
        }
        else if (c1.getValue().equals("Draw 2")) {
            currentValue = "-1";
            pctd +=2;
            currentColor = c1.getColor();
            currentValue = c1.getValue();
            playerHand.remove(c1);
            playerCardsAvalible.remove(c1);
            for (int i = 0; i < 2; i++) {
                draw1Card();
            }
            return "Draw 2"; 
        }
        else if ((c1.getValue().equals("0") || c1.getValue().equals("1") || c1.getValue().equals("2") || c1.getValue().equals("3") || c1.getValue().equals("4") || c1.getValue().equals("5") || c1.getValue().equals("6") || c1.getValue().equals("7") || c1.getValue().equals("8") || c1.getValue().equals("9")) && isCorrectColor(c1) == true) {
            currentValue = c1.getValue();

            discardPile(c1);     
            playerTurn = -(playerTurn);
            currentColor = c1.getColor();
            currentValue = c1.getValue();
            playerHand.remove(c1);
            playerCardsAvalible.remove(c1);
            return "Card played, next persons turn";
        }
        else if((!(c1.getColor().equals(currentColor))) || c1.getValue().equals(currentValue)) {
            if (c1.getValue().equals(currentValue)) {
                currentValue = c1.getValue();
                pctd = 0;
                currentColor = c1.getColor();
                currentValue = c1.getValue();
                playerHand.remove(c1);
            playerCardsAvalible.remove(c1);
                return "Card played";
            }
            else {
                currentColor = c1.getColor();
                currentValue = c1.getValue();
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

    // playerChoice calls the correct method depending on the choice and the card c1
    public String playerChoice(/*ArrayList<unoCards> shuffledDeck, */String choice, unoCards c1) {

        if (choice.equals("draw")) {
            draw1Card();
        }
        else if (choice.equals("playcard")) {
            playCard(c1);
        }
        return choice;
    }
    

    public void makeCardsAvalible() {

        playerCardsAvalible.clear();
        for (int i = 0; i < playerHand.size(); i++) {
            if ((playerHand.get(i).getColor()).equals(currentColor)) {
                playerCardsAvalible.add(playerHand.get(i));
            }
            else if (playerHand.get(i).getValue().equals(currentValue)) {
                playerCardsAvalible.add(playerHand.get(i));
            }
            else {
                // nothing happens delete this 
            }
        }
         // this is the big problem. Needs to make sure if you have 4 draw 4's that they can't exist and also needs to check how many are in the shuffle deck
    /*
    first, it needs to check if the card in the array list exists either 1 time in the deck, or in the players hand
        next it needs to check how many of that card exist in the memory / deck
            then, using that value it will see how many exist in the arrayList already and if the card exists too many times after it was found, it will be deleted and not added back to the array list
                then, it will also see if it is printing a duplicate of that card when the method is run, or if it was a duplicate that was actually drawn

        put code here for "storage" :
        for (int i = 0; i < playerHand.size()-1; i++) {
            if ((playerHand.get(i).getColor()).equals(currentColor)) {
                playerCardsAvalible.add(playerHand.get(i));
            }
            else if (playerHand.get(i).getValue().equals(currentValue)) {
                playerCardsAvalible.add(playerHand.get(i));
            }
            else {
                // nothing happens delete this 
            }
        }


        if index at shuffled deck > 0
            if index at avalibl cards > 0
                then dont add
            else if the card is still in the shuffledDeck
                don't add the card
        else 
            if the card has a value of 0, it only exists 1 time

        at the beginning, check if the card has 2 variants, 1 variant, or 4 variants
    */
    }
    //
     public void makeCardsAvalibleCOM() {
        computerCardsAvalible.clear();
        for (int i = 0; i < computerHand.size(); i++) {
            if ((computerHand.get(i).getColor()).equals(currentColor)) {
                computerCardsAvalible.add(playerHand.get(i));
            }
            else if (playerHand.get(i).getValue().equals(currentValue)) {
                computerCardsAvalible.add(computerHand.get(i));
            }
            else {
                // nothing happens delete this 
            }
        }
    }
    public void makeSureWildNotFirst() {
        if ((shuffledDeck.get(0).getColor()).equals("Wild")) {
            unoCards c2 = new unoCards(shuffledDeck.get(0).getColor(), shuffledDeck.get(0).getValue());
            shuffledDeck.remove(0);
            shuffledDeck.add(c2);

        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
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
    
    // needs to see if the player has the card im looking for, then return that card? Only needs to work with computer bc player chooses their own cards 
    public unoCards computerCardFind(String wantedColor, String wantedValue) {
        for (int i = 0; i < computerHand.size(); i++) {
            if (computerHand.get(i).getColor().equals(wantedColor) && computerHand.get(i).getValue().equals(wantedValue)) {
                return computerHand.get(i);
            }
        }
        return playerHand.get(0);
    }
    public boolean computerCardFindBool(String wantedColor, String wantedValue) {
        if (computerHand.get(i).getColor().equals(wantedColor) && computerHand.get(i).getValue().equals(wantedValue)) {
            return true;
        }
        else {
            return false;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
      
    public void gameDriver() {
        /* 
        System.out.println(shuffledDeck + "\n");

        ArrayList<unoCards> playerHand = makeInitialHands(shuffledDeck);
        playerHand = makeInitialHands(shuffledDeck);
        playerHand.add(draw1Card(shuffledDeck));

        System.out.println(playerHand);
        System.out.println(shuffledDeck);
        */
        

        playerHand = makeInitialHands();
        computerHand = makeInitialHands();
        discardPile(shuffledDeck.get(0));
        
        // the .add function for the discard pile goes in order of when added so we need to access the last added card, not the top card
        //System.out.println(discardPile);
        
        // make the currenct color and value on the top of the discard pile
        currentDiscardColor();
        currentDiscardValue();
        System.out.println(currentColor + " currenct Value: " + currentValue);
        // check anything in player hand
        //System.out.println(playerHand);
        //System.out.println(shuffledDeck);
        Scanner input = new Scanner(System.in);
        while (!(playerHand.isEmpty() || computerHand.isEmpty())) {
            
            // check who has uno
            checkUno();
            // check if they have to draw
            if (pctd > 0) {
                for (int i = pctd; i > 0; i--) {
                    System.out.println("You have to draw 1 card because PCTD = ");
                    draw1Card(); 
                }
                pctd =0;
            }
            makeCardsAvalible();
            // check if they have a card they can play
            if (!(playerCardsAvalible.isEmpty())) { 
                //System.out.println("Your current cards are: " + playerHand + "\nbut these are the ones you can actually play: " + playerCardsAvalible + "\nWhat card will you play? (0 is starting card) 0-" + playerCardsAvalible.size());
                //makeCardsAvalible();
                System.out.println("\nThe current color is: " + currentColor + "    and the current value is: " + currentValue + "\n");
                
                System.out.println("Your current cards are: " + playerHand + "\nbut these are the ones you can actually play: " + playerCardsAvalible + "\nWhat card will you play? (0 is starting card) 0-" + (playerCardsAvalible.size()-1));
                int choice = input.nextInt();
                System.out.println(playCard(playerCardsAvalible.get(choice)));
                //0
                // playerCardsAvalible.remove(choice);
                makeCardsAvalible(); 
            }
            else {
                System.out.println("You cannot play a card so you must draw 1");
                draw1Card();
                System.out.println("New card was: " + playerHand.get((playerHand.size())-1));
                System.out.println(playerHand);
                makeCardsAvalible();
            }
        }
        //System.out.println(playerHand);
        //makeCardsAvalible();
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
    // method to check if the top card is a draw card
    public boolean isTopCardDraw() {
        if (currentValue.equals("Draw 4") || currentValue.equals("Draw 2")) {
            return true;
        }
        else {
            return false;
        }
    }
    /*
    needs to check if theres a wild card, index how many cards they have of that color, then choose accordingly
    */
    public void computerPlayer() {
        if (pctd > 0 && isTopCardDraw() == true) {
            if (computerCardFindBool("Wild", "Draw 4") == true) {
                playCard(computerCardFind("Wild", "Draw 4"));
            }
            else if (computerCardFindBool(currentColor, "Draw 2") == true) {
                playCard(computerCardFind(currentColor, "Draw 2"));
            }
            else {
                computerChoice();
            }
        }
        
        
    } 
    public String computerColorChoice() {
        int blueCards = 0;
        int wildCards = 0;
        int redCards = 0;
        int greenCards = 0;
        int yellowCards = 0;
        
        for (int i = 0; i < computerHand.size(); i++) {
            if (computerHand.get(i).getColor().equals("Green")) {
                greenCards++;
            }
            else if (computerHand.get(i).getColor().equals("Blue")) {
                blueCards++;
            }
            else if (computerHand.get(i).getColor().equals("Yellow")) {
                yellowCards++;
            }
            else if (computerHand.get(i).getColor().equals("Red")) {
                redCards++;
            } 
            else {
                wildCards++;
            }
        }
        // using those values choose which color
        if (blueCards >= redCards && blueCards>=yellowCards && blueCards>=greenCards && blueCards>=wildCards) {
            return "Blue";
        }
        else if (yellowCards >= yellowCards && yellowCards>=blueCards && yellowCards>=greenCards && yellowCards>=wildCards) {
            return "Yellow";
        }
        else if (redCards >= blueCards && redCards>=yellowCards && redCards>=greenCards && redCards>=wildCards) {
            return "Red";
        }
        else if (greenCards >= redCards && greenCards>=yellowCards && greenCards>=blueCards && greenCards>=wildCards) {
            return "Green";
        }
        else if (wildCards >= redCards && wildCards>=yellowCards && wildCards>=greenCards && wildCards>=blueCards) {
            return "Wild";
        }
        else {
            return "Invalid";
        }
    }
    public unoCards findNumCard() {
        for (int i = 0; i < computerCardsAvalible.size(); i++) {
            if (!(computerCardsAvalible.get(i).getColor().equals(currentColor)) && computerCardsAvalible.get(i).getValue().equals(currentValue)) {
                return computerCardsAvalible.get(i);
            }
            else {
                //return null;
            }
        }
        return null;
    }
    public void draw1CardCom() {      
        unoCards c1 = new unoCards(shuffledDeck.get(0).getColor(), shuffledDeck.get(0).getValue());
        computerHand.add(c1);
        shuffledDeck.remove(0);
    }
    public void computerChoice() {
        // needs to know that top card, depends on what cards there are left in deck. also, needs to pick its own cards. use MakeCardsAvalible for computer player or sum
        if (!(computerCardsAvalible.isEmpty())) {
            for (int i = 0; i < computerCardsAvalible.size(); i++) {
                if (isCorrectValue(computerCardsAvalible.get(i)) == true) {   
                    if (!(computerColorChoice().equals(currentColor))) {                  
                        playCard(findNumCard());
                    } 
                }
                else if (computerCardsAvalible.get(i).getColor().equals("Wild")) {
                    playCard(computerCardsAvalible.get(i));
                }
                else if (computerCardsAvalible.get(i).getColor().equals(currentColor)) {
                    playCard(computerCardsAvalible.get(i));
                }               
            }
        }
        else {
            draw1CardCom();
            // draw card for the computer 
        }
    }
} 

// hi 