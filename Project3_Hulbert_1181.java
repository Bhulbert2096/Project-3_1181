/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *Brandon Hulbert
 * CS1181-01
 * Dr.Cheathem
 * Project_3
 */
public class Project3_Hulbert_1181 extends Application
{
    
     
    public static void main(String[] args)
    {
       Application.launch(args);

    }
    
    public static void discard(ArrayDeque _discard,HumanPlayer human,Button card, Deck _deck, Button discardedCard){
       String sCard = card.getText();
        
        for (String HumansHand : human.listHumansHand())
        {
            if(sCard.equals(HumansHand)){
                _deck.AddToDiscardPile(sCard, _discard);
                discardedCard.setText(sCard);
                human.listHumansHand().remove(HumansHand);
                
                System.out.println("HUMAN discarded "+sCard);
                System.out.println("");
                break;
            }
            
        }
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Queue<String> cardDeck = new LinkedList<>();
        ArrayDeque<String> discard = new ArrayDeque<>();
        Scanner input = new Scanner(System.in);
        String cardToRemove = null;
        HumanPlayer human = new HumanPlayer("", "");
        ComputerPlayer computer = new ComputerPlayer("","");
        Deck deck = new Deck();
       
        //this will add cards to the deck
        deck.buildDeck(cardDeck);
       
        
        //this will shuffle the deck
        deck.shuffleDeck(cardDeck);
        //this will add cards to the humans hand
        human.StartingHand(cardDeck);
        
        computer.addComputerPlayersDeck(cardDeck);
       //computer.TEST();
        BorderPane mainPane = new BorderPane();
        //FlowPane humanPane = new FlowPane();
        GridPane humanPane = new GridPane();
        GridPane computerPane = new GridPane();
        GridPane piles = new GridPane();
        Button card1 = new Button(human.listHumansHand().get(0));
        card1.setPrefSize(137, 200);
        
        Button card2 = new Button(human.listHumansHand().get(1));
        card2.setPrefSize(137, 200);
        Button card3 = new Button(human.listHumansHand().get(2));
        card3.setPrefSize(137, 200);
        Button card4 = new Button(human.listHumansHand().get(3));
        card4.setPrefSize(137, 200);
        //this card is the card that is drawn by the user
        Button card5 = new Button();
        card5.setPrefSize(137, 200);
        //this will list all the cards in the deck
        Button drawCard = new Button();
        drawCard.setPrefSize(137, 200);
        Label drawLabel = new Label("Draw Pile");
        Label discardLabel = new Label("Discard Pile");
        Button discardCard = new Button(discard.peek());
        //discardCard.setText(discard.peek());
        discardCard.setPrefSize(137, 200);
        boolean bGameNotOver = false;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //these are the computes buttons
        Button cCard1 = new Button();
        cCard1.setPrefSize(137, 200);
        Button cCard2 = new Button();
        cCard2.setPrefSize(137, 200);
        Button cCard3 = new Button();
        cCard3.setPrefSize(137, 200);
        Button cCard4 = new Button();
        cCard4.setPrefSize(137, 200);
        
        
        
        drawCard.setOnAction(drawEvent ->{
            if(cardDeck.isEmpty()){
                deck.addDiscardPileToDrawPile(discard, cardDeck,discard.size());
            }
            if(human.listHumansHand().size() == 4){
            card5.setVisible(true);
            String cardDrawn = deck.drawACard(cardDeck);
            human.addACardToHand(cardDrawn);
            
            System.out.println("HUMAN DREW "+cardDrawn);
            //this will display the my drawn card
            card5.setText(cardDrawn);
            humanPane.add(card5, 4, 0);
            }
            
            //need to handle the case if the deck is empty
        });
        
        
        discardCard.setOnAction(discardEvent ->{
            if(human.listHumansHand().size() == 4){
            card5.setVisible(true);
            String cardDrawnFromDiscard = deck.getDiscardCardFromPile(discard);
            human.addACardToHand(cardDrawnFromDiscard);
            card5.setText(cardDrawnFromDiscard);
            humanPane.add(card5, 4, 0);
            discardCard.setText(discard.peek());
            }
        });
        
        card1.setOnAction(e ->{
            //if card ones is pressed it will discard it
            if(human.listHumansHand().size() == 5){
           
            discard(discard, human, card1,deck,discardCard);
             //this will play for the computer everytime 1 his clicked
             boolean computerWon;
             computerWon = computer.computersChoiceDraworDiscard(deck, cardDeck,discard,discardCard);
             if(computerWon == true){
                 alert.setHeaderText("The Winner Is:");
                alert.setContentText("Computer Wins");
               Optional<ButtonType> newResult = alert.showAndWait();
               
             }
            card1.setText(card2.getText());
            card2.setText(card3.getText());
            card3.setText(card4.getText());
            card4.setText(card5.getText());
            card5.setVisible(false);
            humanPane.getChildren().remove(card5);
            card5.setVisible(true);
            boolean bGameisOver; 
            bGameisOver = human.gameOver(bGameNotOver);
            if(bGameisOver == true){  
               alert.setHeaderText("The Winner Is:");
                alert.setContentText("You Win");
               Optional<ButtonType> newResult = alert.showAndWait();
               System.exit(0);
            }
            
            }
        });
        
        card2.setOnAction(e ->{
            
                //if card two is pressed it will discard it
            if(human.listHumansHand().size() == 5){
               
            discard(discard, human, card2,deck,discardCard);
             //this will play for the computer everytime 5 his clicked
             boolean computerWon = false;
            computerWon = computer.computersChoiceDraworDiscard(deck, cardDeck,discard,discardCard);
            if(computerWon == true){
                alert.setHeaderText("The Winner Is:");
                alert.setContentText("Computer Wins");
               Optional<ButtonType> newResult = alert.showAndWait();
            }
            card2.setText(card3.getText());
            card3.setText(card4.getText());
            card4.setText(card5.getText());
            //card4.setText(card5.getText());
            card5.setVisible(false);
            humanPane.getChildren().remove(card5);
            card5.setVisible(true);
            boolean bGameisOver; 
            bGameisOver = human.gameOver(bGameNotOver);
            if(bGameisOver == true){
                alert.setHeaderText("The Winner Is:");
                alert.setContentText("You Win");
               Optional<ButtonType> newResult = alert.showAndWait();
               System.exit(0);
            }
            }
            
        });
        
        card3.setOnAction(e ->{
            //if card three is pressed it will discard it
            
            if(human.listHumansHand().size() == 5){
               
            discard(discard, human, card3,deck,discardCard);
             //this will play for the computer everytime 5 his clicked
             boolean computerWon = false;
            computerWon = computer.computersChoiceDraworDiscard(deck, cardDeck,discard,discardCard);
            if(computerWon == true){
                alert.setHeaderText("The Winner Is:");
                alert.setContentText("Computer Wins");
               Optional<ButtonType> newResult = alert.showAndWait();
            }
            card3.setText(card4.getText());
            card4.setText(card5.getText());
            //card4.setText(card5.getText());
            card5.setVisible(false);
            humanPane.getChildren().remove(card5);
            card5.setVisible(true);
            boolean bGameisOver;
            bGameisOver = human.gameOver(bGameNotOver);
            if(bGameisOver == true){
                alert.setHeaderText("The Winner Is:");
                alert.setContentText("You Win");
               Optional<ButtonType> newResult = alert.showAndWait();
               System.exit(0);
            }
            }
            
        });
        
        card4.setOnAction(e ->{
            //if card four is pressed it will discard it
            
            if(human.listHumansHand().size() == 5){
            discard(discard, human, card4,deck,discardCard);
             //this will play for the computer everytime 5 his clicked
             boolean computerWon = false;
            computerWon = computer.computersChoiceDraworDiscard(deck, cardDeck,discard,discardCard);
            if(computerWon == true){
                alert.setHeaderText("The Winner Is:");
                alert.setContentText("Computer Wins");
               Optional<ButtonType> newResult = alert.showAndWait();
            }
            card4.setText(card5.getText());
            card5.setVisible(false);
            humanPane.getChildren().remove(card5);
            boolean bGameisOver; 
            bGameisOver = human.gameOver(bGameNotOver);
            if(bGameisOver == true){
                alert.setHeaderText("The Winner Is:");
                alert.setContentText("You Win");
               Optional<ButtonType> newResult = alert.showAndWait();
               System.exit(0);
            }
            }
            
        });
        
        card5.setOnAction(e ->{
            
            //if card five is pressed it will discard it
            String check;
            discard(discard, human, card5,deck,discardCard);
             //this will play for the computer everytime 5 his clicked
             boolean computerWon = false;
            computerWon = computer.computersChoiceDraworDiscard(deck, cardDeck,discard,discardCard);
            if(computerWon == true){
                alert.setHeaderText("The Winner Is:");
                alert.setContentText("Computer Wins");
               Optional<ButtonType> newResult = alert.showAndWait();
            }
            card5.setText(human.listHumansHand().get(3));
            card5.setVisible(false);
            humanPane.getChildren().remove(card5);
            card5.setVisible(true);
            boolean bGameisOver; 
            bGameisOver = human.gameOver(bGameNotOver);
            if(bGameisOver == true){
                alert.setHeaderText("The Winner Is:");
                alert.setContentText("You Win");
               Optional<ButtonType> newResult = alert.showAndWait();
               System.exit(0);
            }
            
        });
        
        computerPane.setAlignment(Pos.CENTER);
        computerPane.add(cCard1, 0, 0);
        computerPane.add(cCard2, 1, 0);
        computerPane.add(cCard3, 2, 0);
        computerPane.add(cCard4, 3, 0);
        
        humanPane.setAlignment(Pos.CENTER);
        humanPane.add(card1,0,0);
        humanPane.add(card2,1,0);
        humanPane.add(card3,2,0);
        humanPane.add(card4,3,0);
        
        piles.add(drawLabel, 0, 0);
        piles.add(discardLabel,1,0);
        piles.add(drawCard, 0, 1);
        piles.setHgap(50);
        piles.add(discardCard, 1, 1);
        piles.setAlignment(Pos.CENTER);
        
        mainPane.setCenter(piles);
        mainPane.setBottom(humanPane);
        mainPane.setTop(computerPane);
        //mainPane.getChildren().add(humanPane);
        
        Scene scene = new Scene(mainPane,1000,1000);
        stage.setScene(scene);
        stage.show();
    }
    
}
