/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ComputerPlayer extends Deck
{
    private ArrayList<String> ComputerPlayerDeck = new ArrayList<>();

    public ComputerPlayer()
    {
    }
    
    public void addComputerPlayersDeck(){
         for (int i = 1; i < 5;i++)
        {
            //adds the computer players deck
            ComputerPlayerDeck.add(super.getDeck().get(i));
            //System.out.println("("+i+")"+super.getDeck().get(i));
            super.getDeck().remove(super.getDeck().get(i));
        }
    }
    
    public ArrayList<String> listComputerPlayersDeck(){
        
         ComputerPlayerDeck.iterator(); 
         return ComputerPlayerDeck;
    }
    @Override
    public String toString(){
        for (int i = 1; i < 5;i++){
        return String.format("("+i+")"+listComputerPlayersDeck());
        }
      return "";          
    }
}
