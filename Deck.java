/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Admin
 */
public class Deck
{
    
    //private Queue<String> deck = new LinkedList<>();
    private  String[] ranks  = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
    private  String[] suits = { "hearts", "spades", "diamonds", "clubs" };
    //make a private member card called imageview
    //use a loop 13 times take the array and have it find the 2 and find the suit 
    //do res/ doucble loop through both stirngs to find suit and rank
    
    public String[] getRanks()
    {
        return ranks;
    }

    public void setRanks(String[] ranks)
    {
        this.ranks = ranks;
    }

    public String[] getSuits()
    {
        return suits;
    }

    public void setSuits(String[] suits)
    {
        this.suits = suits;
    }

    public void peekAtDiscardPile(ArrayDeque<String> discardPile){
         System.out.println("The top card in the discard pile is the "+ discardPile.peek());
     }
     public void AddToDiscardPile(String sToDiscard,ArrayDeque<String> discardPile){
         
        discardPile.push(sToDiscard);
    }
     public void shuffleDeck(Queue<String> deck){
        Collections.shuffle((LinkedList<String>) deck);
    }
    public String drawACard(Queue<String> _deck){
        
        String drawnCard = _deck.poll();
        return drawnCard;
        
    }
    public String listQueue(Queue<String> deck){
        
        String sDeck = null;
        while(!deck.isEmpty()){
            sDeck = deck.peek();
            return sDeck;
        }
        return null;
    }
    
    public void buildDeck(Queue<String> deck){
        for (int i = 0; i < ranks.length; i++)
        {
            for (int j = 0; j < suits.length;j++)
            {
                deck.offer(ranks[i]+" of "+suits[j]);
                
            }
        }
    }
   
     public String getDiscardCardFromPile(ArrayDeque<String> discard){
         return discard.pop();
     }
     public void addDiscardPileToDrawPile(ArrayDeque<String> discardPile, Queue<String> deck,int ndiscard){
         
         String sDiscardedCard;
             for(int i = 0; i < ndiscard; i++){
                 sDiscardedCard = discardPile.pop();
                 deck.offer(sDiscardedCard);
             }
         }
//     public void buildDeck2(Queue<String> deck){
//         for (int i = 0; i <ranks.length; i++)
//         {
//             for (int j = 0; j < suits.length; j++)
//             {
//                 deck.offer(new ImageView(new Image(new File(ranks[i]+"_of_"+suits[j]+".jpeg").toURI().toString())));
//             }
//         }
//         
//     }
}

