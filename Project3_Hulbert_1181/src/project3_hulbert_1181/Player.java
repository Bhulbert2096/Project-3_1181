/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

/**
 *
 * @author Admin
 */
public abstract class Player extends Card
{

    public Player(String sNumberOnCard, String sSuitOfCard)
    {
        super(sNumberOnCard, sSuitOfCard);
    }
    //have an add card method to add to the player from the draw method
   
    public abstract void addCardsToHand();
    
    public abstract String displayHand();
    
    
    
    
    
    
}
