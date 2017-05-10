/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import javafx.scene.control.Button;

/**
 *
 * @author Admin
 */
public class ComputerPlayer extends Card
{

    private ArrayList<String> ComputerPlayerDeck = new ArrayList<>();
    private ArrayList<String> match = new ArrayList<>();

    public ComputerPlayer(String sNumberOnCard, String sSuitOfCard)
    {
        super(sNumberOnCard, sSuitOfCard);
    }

    public void addComputerPlayersDeck(Queue<String> _deck)
    {
        //this will take cards from the queue and add them to the computers hand
        for (int i = 1; i < 5; i++)
        {
            ComputerPlayerDeck.add(_deck.poll());
        }
    }

    public void addACardToCompsHand(String sCardToAdd)
    {
        ComputerPlayerDeck.add(sCardToAdd);
    }

    public ArrayList<String> listComputerDeck()
    {
        return ComputerPlayerDeck;
    }

    public void printComputersDeck()
    {
        int count = 1;
        System.out.println("Computers cards are: ");
        for (int i = 0; i < ComputerPlayerDeck.size(); i++)
        {
            System.out.println("\t" + ComputerPlayerDeck.get(i));
            count++;
        }
    }

    public boolean gameOver(boolean gameisOver)
    {
        gameisOver = false;

        if (((ComputerPlayerDeck.get(0).charAt(0) == ComputerPlayerDeck.get(1).charAt(0))) && ((ComputerPlayerDeck.get(2).charAt(0)) == (ComputerPlayerDeck.get(3).charAt(0))))
        {

            if ((ComputerPlayerDeck.get(0).charAt(0) == ComputerPlayerDeck.get(2).charAt(0)) && (ComputerPlayerDeck.get(0).charAt(0) == ComputerPlayerDeck.get(3).charAt(0)))
            {
                System.out.println("GAME IS OVER");
            }
        }

        return gameisOver;
    }

    //this is only a test
    public void TEST()
    {
        ComputerPlayerDeck.add("6 of hearts");
        ComputerPlayerDeck.add("3 of hearts");
        ComputerPlayerDeck.add("6 of spades");
        ComputerPlayerDeck.add("6 of diamonds");

    }

    public void ComputerDiscard(ArrayDeque _discard, Deck _deck, Button discardedCard)
    {
        int nRandomChoice = (int) (0 + Math.random() * 6);
        String sCardToDiscard = null;
        for (int i = 0; i < listComputerDeck().size(); i++)
        {

            if (nRandomChoice == i)
            {

                sCardToDiscard = listComputerDeck().get(i);
                System.out.println("COMPUTER DISCARDED " + sCardToDiscard);
                System.out.println("");
                _deck.AddToDiscardPile(sCardToDiscard, _discard);
                discardedCard.setText(sCardToDiscard);
                listComputerDeck().remove(i);

            }

        }
      
    }

    public boolean computersChoiceDraworDiscard(Deck _deck, Queue<String> _cardDeck, ArrayDeque<String> _discard, Button discardButton)
    {

        int nComputeresRandomChoice = (int) (0 + Math.random() * 2);
        printComputersDeck();

        boolean isGameOver = false;
        String sCardToDrawComputer;
        if (nComputeresRandomChoice == 0)
        {
            sCardToDrawComputer = _deck.drawACard(_cardDeck);
            System.out.println("COMPUTER WILL DRAW A NEW CARD");
            System.out.println("");
            addACardToCompsHand(sCardToDrawComputer);
            ComputerDiscard(_discard, _deck, discardButton);
            if(ComputerPlayerDeck.size() == 5){
                int nRandomChoice = (int) (0 + Math.random() * 6);
                for (int i = 0; i < 5; i++)
                {
                    if(nRandomChoice == i){
                        ComputerPlayerDeck.remove(i);
                    }
                }
            }
            isGameOver = gameOver(isGameOver);

        }
        else
        {

            //computer chose to pickup from the discardpile
            System.out.println("COMPUTER WILL PICK UP " + _discard.peek());
            System.out.println("");
            addACardToCompsHand(_discard.pop());
            ComputerDiscard(_discard, _deck, discardButton);
            discardButton.setText(_discard.peek());
             if(ComputerPlayerDeck.size() == 5){
                int nRandomChoice = (int) (0 + Math.random() * 6);
                for (int i = 0; i < 5; i++)
                {
                    if(nRandomChoice == i){
                        ComputerPlayerDeck.remove(i);
                    }
                }
            }
            isGameOver = gameOver(isGameOver);
        }
        printComputersDeck();

        return isGameOver;
    }

}
