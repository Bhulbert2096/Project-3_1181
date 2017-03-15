/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class HumanPlayer extends Player
{   
private  ArrayList<String> humanPlayerDeck = new ArrayList<>();
 //private Queue<String> humanPlayerDeck = new LinkedList<>();   

    public HumanPlayer(String sNumberOnCard, String sSuitOfCard)
    {
        super(sNumberOnCard, sSuitOfCard);
    }
    
    
    
   
    
    public ArrayList<String> listHumanPlayersDeck(){
        for(int i = 0; i < humanPlayerDeck.size(); i++){
         
         return humanPlayerDeck;
        }
        return humanPlayerDeck;
    }
    @Override
    public String toString(){
        for (int i = 1; i < 5;i++){
        return String.format("("+i+")"+listHumanPlayersDeck());
        }
      return "";          
    }

    @Override
    public void addCardsToHand()
    {
        
    }

    @Override
    public String displayHand()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
