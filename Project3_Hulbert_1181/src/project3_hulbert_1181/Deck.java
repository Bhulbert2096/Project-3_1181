/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class Deck
{
    //private ArrayList<String> deck = new ArrayList<>();
    private Queue<String> deck = new LinkedList<>();
    private final ArrayDeque<String> discard = new ArrayDeque<>();
    
    public Deck()
    {
       
    }


    public void discardPile(String sToDiscard){
        discard.offer(sToDiscard);
    }

    public String getDraw(String cardRemoved)
    {
        //this will remove the card from the queue 
        //this is done jsut before it is given to the player
        cardRemoved =deck.poll();
        return cardRemoved;
   }
    public Queue<String> listQueue(){
        for (int i = 0; i < deck.size(); i++)
        {
            
            return deck;
        }
        return deck;
    }
    
    public void unshuffeledDeck(){
        deck.offer("2 of Hearts");
        deck.offer("3 of Hearts");
        deck.offer("4 of Hearts");
        deck.offer("5 of Hearts");
        deck.offer("6 of Hearts");
        deck.offer("7 of Hearts");
        deck.offer("8 of Hearts");
        deck.offer("9 of Hearts");
        deck.offer("10 of Hearts");
        deck.offer("Jack of Hearts");
        deck.offer("Queen of Hearts");
        deck.offer("King of Hearts");
        deck.offer("Ace of Hearts");
        
        deck.offer("2 of Diamonds");
        deck.offer("3 of Diamonds");
        deck.offer("4 of Diamonds");
        deck.offer("5 of Diamonds");
        deck.offer("6 of Diamonds");
        deck.offer("7 of Diamonds");
        deck.offer("8 of Diamonds");
        deck.offer("9 of Diamonds");
        deck.offer("10 of Diamonds");
        deck.offer("Jack of Diamonds");
        deck.offer("Queen of Diamonds");
        deck.offer("King of Diamonds");
        deck.offer("Ace of Diamonds");

        deck.offer("2 of Spades");
        deck.offer("3 of Spades");
        deck.offer("4 of Spades");
        deck.offer("5 of Spades");
        deck.offer("6 of Spades");
        deck.offer("7 of Spades");
        deck.offer("8 of Spades");
        deck.offer("9 of Spades");
        deck.offer("10 of Spades");
        deck.offer("Jack of Spades");
        deck.offer("Queen of Spades");
        deck.offer("King of Spades");
        deck.offer("Ace of Spades");
        
        deck.offer("2 of Clubs");
        deck.offer("3 of Clubs");
        deck.offer("4 of Clubs");
        deck.offer("5 of Clubs");
        deck.offer("6 of Clubs");
        deck.offer("7 of Clubs");
        deck.offer("8 of Clubs");
        deck.offer("9 of Clubs");
        deck.offer("10 of Clubs");
        deck.offer("Jack of Clubs");
        deck.offer("Queen of Clubs");
        deck.offer("King of Clubs");
        deck.offer("Ace of Clubs");
        
        
        
    }
}
