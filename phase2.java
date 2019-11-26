import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.lang.model.util.ElementScanner6;
import java.util.Random;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/*********************************************************************
 * Phase 2
 * 
 * CardTable
 * description:  creates CardTable class that extends JFrame
 * usage:        controls the positioning of the panels and 
 *               cards of the GUI
 * GUI Cards
 * description:  creates a new GUICard class 
 * usage:        manages the reading and building of the card
 *               image Icons
 *********************************************************************/

 /******************************
  * client (main)
  ******************************/
  public class phase2
  {
     static int NUM_CARDS_PER_HAND = 7;
     static int  NUM_PLAYERS = 2;
     static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
     static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
     static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
     static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
     
     public static void main(String[] args)
     {
        Icon tempIcon;
  
        //Icons loaded from GUICard 
        GUICard.loadCardIcons();
        
        // establish main frame in which program will run
        CardTable myCardTable 
           = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
        myCardTable.setSize(800, 600);
        myCardTable.setLocationRelativeTo(null);
        myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        // show everything to the user
        myCardTable.setVisible(true);
  
        // CREATE LABELS ----------------------------------------------------
        for (int card = 0; card < NUM_CARDS_PER_HAND; card++)
        {
           //back labels made for playing cards 
           computerLabels[card] = new JLabel(GUICard.getBackCardIcon());
  
           //label for random card 
           tempIcon = GUICard.getIcon(randomCardGenerator());
           humanLabels[card] = new JLabel(tempIcon);
        }
    
        // ADD LABELS TO PANELS -----------------------------------------
        for (int card = 0; card < NUM_CARDS_PER_HAND; card++)
        {
           //index label added to computer panel 
           myCardTable.pnlComputerHand.add(computerLabels[card]);
  
           //index label added to human panel
           myCardTable.pnlHumanHand.add(humanLabels[card]);
        }
        
        // and two random cards in the play region (simulating a computer/hum ply)
        //code goes here ...
        for (int card = 0; card < NUM_PLAYERS; card++)
        {
           //random card generated 
           tempIcon = GUICard.getIcon(randomCardGenerator());
           //assigns labels to played card 
           playedCardLabels[card] = new JLabel(tempIcon);
           //assigns labels to played area 
           myCardTable.pnlPlayArea.add(playedCardLabels[card]);
        }
  
        // show everything to the user
        myCardTable.setVisible(true);
     }
  
     /**
      * returns a new random card for the main to use in its test 
      * @return card 
      */
      static Card randomCardGenerator()
      {
         Deck deck = new Deck();
         Random randomGen = new Random();
         return deck.inspectCard(randomGen.nextInt(deck.getNumCards()));
      }
  }