/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_hulbert_1181;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Card extends Deck
{
   private String sNumberOnCard;
    private String sSuitOfCard;
    public Card(String sNumberOnCard, String sSuitOfCard)
    {
        this.sNumberOnCard = sNumberOnCard;
        this.sSuitOfCard = sSuitOfCard;
    }

    public String getsNumberOnCard(HumanPlayer _human)
    {
       
        return sNumberOnCard;
    }

    public void setsNumberOnCard(String sNumberOnCard)
    {
        this.sNumberOnCard = sNumberOnCard;
    }

    public String getsSuitOfCard()
    {
        return sSuitOfCard;
    }

    public void setsSuitOfCard(String sSuitOfCard)
    {
        this.sSuitOfCard = sSuitOfCard;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.sNumberOnCard, other.sNumberOnCard))
        {
            return false;
        }
        if (!Objects.equals(this.sSuitOfCard, other.sSuitOfCard))
        {
            return false;
        }
        return true;
    }

   
  
   
    
}
