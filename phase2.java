import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/*********************************************************************
 * Phase 2
 * client (main)
 * CardTable
 * GUI Cards
 * Card import
 * Hand import 
 * Deck import 
 * 
 * CardTable
 * description:  creates CardTable class that extends JFrame
 * usage:        controls the positioning of the panels and 
 *               cards of the GUI
 * GUI Cards
 * description:  creates a new GUICard class 
 * usage:        manages the reading and building of the card
 *               image Icons
 * 
 * client (main)
 * @todo         --create and add labels to panel in client (main)--
 *               static Card randomCardGenerator()
 * 
 * CardTable
 * @todo         public CardTable(title, numCardsPerHand, numPlayers)
 *               public getNumCardsPerHand() ....done
 *               public getNumPlayers() ....done
 * 
 * 
 * GUI Cards
 * @todo         static void loadCardIcons()
 *               static public getIcon(Card card)
 *               static public Icon getBackCardIcon()
 * 
 * Card import
 * @todo         --import Card from Assig3--
 *               --adjust for joker--
 *               public static char[] valuRanks()
 *               static void arraySort(Card[], int arraySize)
 *               
 * Hand import
 * @todo         void sort()
 *               public Card playCard(int cardIndex) ....done
 * 
 * Deck import
 * @todo         --import Deck from Assig3--
 *               --adjust for the joker in MasterPack--
 *               boolean addCard(Card card)
 *               boolean removeCard(Card card)
 *               void sort()
 *               int getNumCards()
 *                             
 *           
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
      int k;
      Icon tempIcon;
      
      // establish main frame in which program will run
      CardTable myCardTable 
         = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // show everything to the user
      myCardTable.setVisible(true);

      // CREATE LABELS ----------------------------------------------------
      //code goes here ...
  
      // ADD LABELS TO PANELS -----------------------------------------
      //code goes here ...
      
      // and two random cards in the play region (simulating a computer/hum ply)
      //code goes here ...

      // show everything to the user
      myCardTable.setVisible(true);
   }

   /**
    * returns a new random card for the main to use in its test 
    * @return card 
    */
    static Card randomCardGenerator()
    {

    }
}
/*-----------------------------
 * End of phase2 client (main)
 * ----------------------/

/*********************************************************************
 * CardTable
 * 
 * description:  creates CardTable class that extends JFrame
 * usage:        controls the positioning of the panels and 
 *               cards of the GUI
 * 
 * @todo         create and add labels to panel in main
 *               public CardTable(title, numCardsPerHand, numPlayers)
 *               public getNumCardsPerHand() ....done
 *               public getNumPlayers() ....done
 **********************************************************************/
class CardTable extends Jframe
{
   //members establish the grid layout for the JPanels 
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2;
   private int numCardsPerHand;
   private int numPlayers;
   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;

   /**
    * constructor filters input, adds any panels to the Jframe
    * and establishes layouts accordingly. 
    * @param title
    * @param numCardsPerHand
    * @param numPlayers
    */
   public CardTable(String title, int numCardsPerHand, int numPlayers)
   {

   }

   //accessors 
   public int getNumCardsPerHand()
   {
      return numCardsPerHand;
   }
   public int getNumPlayers()
   {
      return numPlayers;
   }
}
/*-----------------------------------------------------
 * End Of CardTable
 *-----------------------------------------------/


 /****************************************************************
 * GUI Cards
 * 
 * description:  creates a new GUICard class 
 * usage:        manages the reading and building of the card
 *               image Icons.
 * 
 * @todo         static void loadCardIcons()
 *               static public getIcon(Card card)
 *               static public Icon getBackCardIcon()
 *****************************************************************/
class GUICards
{
   //members to facilitate GUICard class 
   private static Icon[][] iconCards = new ImageIcon[14][4]; 
   private static Icon iconBack;
   static boolean iconsLoaded = false;

   /**
    * generates the image icon array from files 
    */
   static void loadCardIcons()
   {

   }

   /**
    * turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
    */
    static String turnIntIntoCardValue(int k)
    {
      //from phase 1
    }

    /**
     * turns 0 - 3 into "C", "D", "H", "S"
     */
    static String turnIntIntoCardSuit(int j)
    {
      // from phase 1
    }
}
/*-----------------------------------------------------
 * End Of GUI Card
 *-----------------------------------------------/



/****************************************************************
 * Card
 * import Card class 
 * 
 * @todo    --import Card class from Assig3--
 *          --adjust for joker-- 
 *          public static char[] valuRanks
 *          static arraySort(Card[], int arraySize) 
 ***************************************************************/ 
class Card 
{
   /**
    * Card class addendum 1
    * puts the order of the card values with smallest first 
    * include 'X' for joker. 
    */
    public static char[] valuRanks()
    {

    }

    /**
     * Card class addendum 2
     * sorts the incoming array of cards using bubble sort routine.
     * break into smaller method if >20 lines. 
     */
    static void arraySort(Card[], int arraySize)
    {

    }
}
/*-----------------------------------------------------
 * End Of Card
 *----------------------------------------------/


 /****************************************************************
 * Hand 
 * imported Hand class 
 * 
 * @todo         import Hand from Assig3
 *               void sort()
 *               public Card playCard(int cardIndex) ....done 
 ***************************************************************/ 
class Hand
{
   /**
    * Hand class addendum1 
    * sorts the hand by calling arraySort() method in the 
    * Card class.
    */
   void sort()
   {
      //calls arraySort()
   }

   /**
    * Hand class addendum2
    * required for phase 3
    *
    * removes the card at a location and slides all of the
    * cards down one spot in the myCards array.
    * @param cardIndex
    * @return
    */
   public Card playCard(int cardIndex)
   {
      if ( numCards == 0 ) //error
      {
         //Creates a card that does not work
         return new Card('M', Card.Suit.spades);
      }
      //Decreases numCards.
      Card card = myCards[cardIndex];
      
      numCards--;
      for(int i = cardIndex; i < numCards; i++)
      {
         myCards[i] = myCards[i+1];
      }
      
      myCards[numCards] = null;
      
      return card;
    }
}
/*-----------------------------------------------------
 * End Of Hand
 *----------------------------------------------/


 /****************************************************************
 * Deck import
 * imported Deck class
 * 
 * @todo         --import Deck from Assig3--
 *               --adjust for the joker in MasterPack--
 *               boolean addCard(Card card)
 *               boolean removeCard(Card card)
 *               void sort()
 *               int getNumCards()
 ***************************************************************/ 
class Deck 
{
   /**
    * Deck class addendum1
    * makes sure there aren't too many instances of the card 
    * in the deck returning false if too many.
    * @return boolean 
    */
    public boolean addCard(Card card)
    {

    }

    /**
     * Deck class addendum2
     * looks to remove specific card from the deck. 
     * puts the top card into its place.
     * if card not in deck anymore return false. 
     * @return boolean
     */
    public boolean removeCard(Card card)
    {

    }

    /**
     * Deck class addendum3
     * puts all cards in deck back in order according to value.
     */
    public void sort()
       {
          //calls arraySort()
       }
    
   /**
    * Deck class addendum4
    * returns the number of cards remaining in the deck 
    */
    public int getNumCards()
    {
       
    }
}
/*-----------------------------------------------------
 * End Of Deck
 *----------------------------------------------/


 