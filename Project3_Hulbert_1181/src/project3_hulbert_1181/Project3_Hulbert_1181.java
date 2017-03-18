/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class Project3_Hulbert_1181 extends Application
{
     
    public static void main(String[] args)
    {
        Application.launch(args);
//        Queue<String> cardDeck = new LinkedList<>();
//        ArrayDeque<String> discard = new ArrayDeque<>();
//        Scanner input = new Scanner(System.in);
//        String cardToRemove = null;
//        HumanPlayer human = new HumanPlayer("", "");
//        ComputerPlayer computer = new ComputerPlayer("","");
//        
//        
//        
//        unshuffeledDeck(cardDeck);
//        shuffleDeck(cardDeck);
//        
//        //*********************************
//        
//        //adds the cards to the users deck
//        human.StartingHand(cardDeck);
//        //This lists the humans hand
//        human.printList();
//        System.out.println("");
//        //this will add cards to the computers hand
//        computer.addComputerPlayersDeck(cardDeck);
//        System.out.println("The discard pile is currently empty -- you must draw a card");
//        System.out.println("You drew the "+cardDeck.peek());
//        human.addACardToHand(drawACard(cardDeck));
//        MainOperations(discard, human, input, cardDeck, computer);
        
                 
    }
    public static void MainOperations(ArrayDeque<String> _discard, HumanPlayer _human,Scanner input,Queue<String> _cardDeck,ComputerPlayer _computer){
          do{
        //need to add if they are equal check for winners method
        //had to pass the human object otherwise a new arraylist is created
        int nComputeresRandomChoice = (int)(0+Math.random()*2);
        String sCardToDrawHuman;
        String sCardToDrawComputer;
        sCardToDrawHuman = drawACard(_cardDeck);
        
        _human.printList();
        System.out.println("");
        //human discarded
        discard(input, _discard, _human);
        //then check for winner here
        //the computer chose to draw a card
        if(nComputeresRandomChoice == 0){
            sCardToDrawComputer = drawACard(_cardDeck);
            System.out.println("I will draw a new card.");
            _computer.addACardToCompsHand(sCardToDrawComputer);
            ComputerDiscard(_discard, _computer);
        }else{
            //computer chose to pickup from the discardpile
            System.out.println("I will pick up "+_discard.peek());
           _computer.addACardToCompsHand(_discard.pop());
            ComputerDiscard(_discard, _computer);
        }
        _human.printList();
       peekAtDiscardPile(_discard);
            System.out.println("Do you want to pick up the "+_discard.peek()+" (1) or draw a card (2)?");
           int nPickOrDraw = input.nextInt();
           //this will add the card to my deck
           if(nPickOrDraw == 1){
               _human.addACardToHand(_discard.pop());
               //if the user picks 2 then draw a card
           }else if(nPickOrDraw == 2){
               sCardToDrawHuman = drawACard(_cardDeck);
               System.out.printf("You drew the %s ",sCardToDrawHuman);
               _human.addACardToHand(sCardToDrawHuman);
           }
//        _human.printList();
       
        
        
        }while(!_human.listHumansHand().isEmpty());
    }
    public static void ComputerDiscard(ArrayDeque _discard,ComputerPlayer _computer){
        int nRandomChoice = (int) (0+Math.random()*6);
        String sCardToDiscard = null;
          for(int i = 0; i < _computer.listComputerDeck().size();i++){
            
            if(nRandomChoice == i){
                
                sCardToDiscard = _computer.listComputerDeck().get(i);
                System.out.println("I will discard the "+sCardToDiscard);
                AddToDiscardPile(sCardToDiscard, _discard);
                _computer.listComputerDeck().remove(i);
            }
        
        }
          
        
    }
    public static void discard(Scanner input,ArrayDeque _discard,HumanPlayer human){
        
        System.out.print("Which one do you want to discard? ");
        
        int nCardToRemove = input.nextInt();
        String cardToDiscard = null;
        switch (nCardToRemove)
        {
            case 1:
                nCardToRemove = 0;
                break;
            case 2:
                nCardToRemove = 1;
                break;
            case 3:
                nCardToRemove = 2;
                break;
            case 4:
                nCardToRemove = 3;
                break;
            case 5:
                nCardToRemove = 4;
                break;
            default:
                break;
        }
        for(int i = 0; i < human.listHumansHand().size();i++){
            
            if(nCardToRemove == i){
                
                cardToDiscard = human.listHumansHand().get(i);
                AddToDiscardPile(cardToDiscard, _discard);
                human.listHumansHand().remove(i);
            }
        
        }
        
    }
     public static String listQueue(Queue<String> deck){
        
        String sDeck = null;
        while(!deck.isEmpty()){
            sDeck = deck.peek();
            return sDeck;
        }
        return null;
    }
     public static void peekAtDiscardPile(ArrayDeque<String> discardPile){
         System.out.println("The top card in the discard pile is the "+ discardPile.peek());
     }
     public static void AddToDiscardPile(String sToDiscard,ArrayDeque<String> discardPile){
         
        discardPile.offer(sToDiscard);
    }
     public static void shuffleDeck(Queue<String> deck){
        Collections.shuffle((LinkedList<String>) deck);
    }
    public static String drawACard(Queue<String> _deck){
        
        String drawnCard = _deck.poll();
        return drawnCard;
        
    }
    public static String listDiscardPile(ArrayDeque<String> discard){
        String sDiscard = null;
        while(!discard.isEmpty()){
            sDiscard = discard.peek();
            return sDiscard;
        }
        return "";
    }
     public static void unshuffeledDeck(Queue<String> deck){
        deck.offer("Two of Hearts");
        deck.offer("Three of Hearts");
        deck.offer("Four of Hearts");
        deck.offer("Five of Hearts");
        deck.offer("Six of Hearts");
        deck.offer("Seven of Hearts");
        deck.offer("Eight of Hearts");
        deck.offer("Nine of Hearts");
        deck.offer("Ten of Hearts");
        deck.offer("Jack of Hearts");
        deck.offer("Queen of Hearts");
        deck.offer("King of Hearts");
        deck.offer("Ace of Hearts");
        
        deck.offer("Two of Diamonds");
        deck.offer("Three of Diamonds");
        deck.offer("Four of Diamonds");
        deck.offer("Five of Diamonds");
        deck.offer("Six of Diamonds");
        deck.offer("Seven of Diamonds");
        deck.offer("Eight of Diamonds");
        deck.offer("Nine of Diamonds");
        deck.offer("Ten of Diamonds");
        deck.offer("Jack of Diamonds");
        deck.offer("Queen of Diamonds");
        deck.offer("King of Diamonds");
        deck.offer("Ace of Diamonds");

        deck.offer("Two of Spades");
        deck.offer("Three of Spades");
        deck.offer("Four of Spades");
        deck.offer("Five of Spades");
        deck.offer("Six of Spades");
        deck.offer("Seven of Spades");
        deck.offer("Eight of Spades");
        deck.offer("Nine of Spades");
        deck.offer("Ten of Spades");
        deck.offer("Jack of Spades");
        deck.offer("Queen of Spades");
        deck.offer("King of Spades");
        deck.offer("Ace of Spades");
        
        deck.offer("Two of Clubs");
        deck.offer("Three of Clubs");
        deck.offer("Four of Clubs");
        deck.offer("Five of Clubs");
        deck.offer("Six of Clubs");
        deck.offer("Seven of Clubs");
        deck.offer("Eight of Clubs");
        deck.offer("Nine of Clubs");
        deck.offer("Ten of Clubs");
        deck.offer("Jack of Clubs");
        deck.offer("Queen of Clubs");
        deck.offer("King of Clubs");
        deck.offer("Ace of Clubs");
        
        //split string into substrings 
        
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Queue<String> cardDeck = new LinkedList<>();
        ArrayDeque<String> discard = new ArrayDeque<>();
        //Scanner input = new Scanner(System.in);
        String cardToRemove = null;
        HumanPlayer human = new HumanPlayer("", "");
        ComputerPlayer computer = new ComputerPlayer("","");
       
        unshuffeledDeck(cardDeck);
        shuffleDeck(cardDeck);
        human.StartingHand(cardDeck);
       
        BorderPane mainPane = new BorderPane();
        //FlowPane humanPane = new FlowPane();
        GridPane humanPane = new GridPane();
        GridPane piles = new GridPane();
        Button card1 = new Button(human.listHumansHand().get(0));
        card1.setPrefSize(100, 200);
        Button card2 = new Button(human.listHumansHand().get(1));
        card2.setPrefSize(100, 200);
        Button card3 = new Button(human.listHumansHand().get(2));
        card3.setPrefSize(100, 200);
        Button card4 = new Button(human.listHumansHand().get(3));
        card4.setPrefSize(100, 200);
        //this card is the card that is drawn by the user
        Button card5 = new Button(drawACard(cardDeck));
        card5.setPrefSize(100, 200);
        //this will list all the cards in the deck
        Button drawCard = new Button(listQueue(cardDeck));
        drawCard.setPrefSize(100, 200);
        Button discardCard = new Button(listDiscardPile(discard));
        discardCard.setPrefSize(100, 200);
        
        
        
        
        
        
        
        
        
        
        
        
        humanPane.setAlignment(Pos.CENTER);
        humanPane.add(card1,0,0);
        humanPane.add(card2,1,0);
        humanPane.add(card3,2,0);
        humanPane.add(card4,3,0);
        
        piles.add(drawCard, 0, 0);
        piles.setHgap(50);
        piles.add(discardCard, 1, 0);
        piles.setAlignment(Pos.CENTER);
        
        mainPane.setCenter(piles);
        mainPane.setBottom(humanPane);
        //mainPane.getChildren().add(humanPane);
        
        Scene scene = new Scene(mainPane,500,500);
        stage.setScene(scene);
        stage.show();
    }
    
}
