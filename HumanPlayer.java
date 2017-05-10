/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class HumanPlayer extends Card
{

    private ArrayList<String> humanPlayerDeck = new ArrayList<>();

    //private Queue<String> humanPlayerDeck = new LinkedList<>();   
    public HumanPlayer(String sNumberOnCard, String sSuitOfCard)
    {
        super(sNumberOnCard, sSuitOfCard);
    }

    public void StartingHand(Queue<String> _deck)
    {
        //this will take the cards from the deck queue and place them into the human
        //players hand which is an arrayList()
        for (int i = 0; i < 4; i++)
        {
            humanPlayerDeck.add(_deck.poll());
        }
    }

    public boolean gameOver(boolean gameisOver)
    {
        gameisOver = false;

        if (((humanPlayerDeck.get(0).charAt(0) == humanPlayerDeck.get(1).charAt(0))) && ((humanPlayerDeck.get(2).charAt(0)) == (humanPlayerDeck.get(3).charAt(0))))
        {

            if ((humanPlayerDeck.get(0).charAt(0) == humanPlayerDeck.get(2).charAt(0)) && (humanPlayerDeck.get(0).charAt(0) == humanPlayerDeck.get(3).charAt(0)))
            {
                System.out.println("GAME IS OVER");
                gameisOver = true;
            }
        }
        return gameisOver;
    }

    public void addACardToHand(String newCard)
    {
        humanPlayerDeck.add(newCard);
    }

    public ArrayList<String> listHumansHand()
    {

        return humanPlayerDeck;
    }

    public void printList()
    {
        int count = 1;
        System.out.println("Now your cards are: ");
        for (int i = 0; i < humanPlayerDeck.size(); i++)
        {
            System.out.println("(" + count + ") " + humanPlayerDeck.get(i));
            count++;
        }
    }

//    @Override
//    public void addCardsToHand()
//    {
//        
//    }
//
//    @Override
//    public String displayHand()
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
