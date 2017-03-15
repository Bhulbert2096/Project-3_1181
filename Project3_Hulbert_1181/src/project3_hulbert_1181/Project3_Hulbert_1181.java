/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class Project3_Hulbert_1181
{
     
    public static void main(String[] args)
    {
        ArrayList<String> shuffledDeck = new ArrayList<>();
        String cardToRemove = null;
        Deck cardDeck = new Deck();
        HumanPlayer human = new HumanPlayer("", "");
        ComputerPlayer computer = new ComputerPlayer();
        cardDeck.unshuffeledDeck();
//        this shuffles the deck
         Collections.shuffle((LinkedList<String>)cardDeck.listQueue());
        //this will print out 4 cards for the human player
        System.out.println("Your hand");
//        human.addHumanPlayersDeck();
//        human.toString();
        
        // this will remove 4 cards and store them in a new arraylist for the human player
         for (int i = 0; i < 5; i++)
        {
            shuffledDeck.add(cardDeck.listQueue().poll());
            
        }
        System.out.println(shuffledDeck);
                 
    }
    
}
