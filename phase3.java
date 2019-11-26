import java.awt.*;
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Random;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/************************************************************************
 * Low-Card Game Logic
 * 
 * @todo         #create action listeners.
 *               #place low card in winning[] array.
 *               #add JLabels.
 *               #decide how to select a card from your hand (button?).
 *               #decide how the computer plays. 
 *                   -intentionally lose? always win?
 *               #decide how to update cards or the computer's cards to                reflect one fewer card every round so that 
 *                   reflect one fewer card every round 
 *                   so that hands get smaller.
 * 
 * 
 ***********************************************************************/

public class phase3 implements ActionListener
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS];
   static JButton cardButtons[] = new JButton[NUM_CARDS_PER_HAND];
   static Card[] compWinnings = new Card[57]; //fix size and instantiate in main
   static Card[] humanWinnings = new Card[57]; //fix size instantiate in main
   static CardGameFramework LowCardGame;
   static Icon tempIcon;
   static CardTable myCardTable;
   static int computerWinningsCounter = 0;
   static int humanWinningsCounter = 0;
   
   public static void main(String[] args)
   {
      phase3 gamePlay = new phase3();
   }

   public phase3()
   {
      int numPacksPerDeck = 1;
      int numJokersPerPack = 4;
      int numUnusedCardsPerPack = 0;
      Card[] unusedCardsPerPack = null;

      LowCardGame = new CardGameFramework(
         numPacksPerDeck, numJokersPerPack,
         numUnusedCardsPerPack, unusedCardsPerPack,
         NUM_PLAYERS, NUM_CARDS_PER_HAND
         );

      LowCardGame.deal();
    
      //Icons loaded from GUICard 
      GUICard.loadCardIcons();
      
      // establish main frame in which program will run
      myCardTable 
         = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // show everything to the user
      myCardTable.setVisible(true);
      
      // Create the card labels and add them into the GUI
      createLabels();

      // show everything to the user
      myCardTable.setVisible(true);
   }

   /* 
    * Helper method to create all the card labels on the game table
    */
   private void createLabels()
   {
      // Create the labels
      for (int card = 0; card < NUM_CARDS_PER_HAND; card++)
      {
         //back labels made for playing cards 
         computerLabels[card] = new JLabel(GUICard.getBackCardIcon());
         
         //labels for each card in the user's hand
         tempIcon = GUICard.getIcon(LowCardGame.getHand(1).inspectCard(card));

         //humanLabels[card] = new JLabel(tempIcon);
         cardButtons[card] = new JButton(tempIcon);
         cardButtons[card].setActionCommand(Integer.toString(card));
         cardButtons[card].addActionListener(this);
      }
      
      // Add the labels to top and bottom panels
      for (int card = 0; card < NUM_CARDS_PER_HAND; card++)
      {
         // index label added to computer panel
         myCardTable.pnlComputerHand.add(computerLabels[card]);
         
         // index label added to human panel
         myCardTable.pnlHumanHand.add(cardButtons[card]);
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) 
   {
      // Get the card that the user played
      String cardPlayed = e.getActionCommand();
      int cardNum = Integer.parseInt(cardPlayed);
           
      // Sort the computer's hand to get the lowest card     
      LowCardGame.getHand(0).sort();

      // Get each player's card icons to be displayed in the playing area
      Icon playerIcon = GUICard.getIcon(LowCardGame.getHand(1).inspectCard(cardNum));
      Icon compIcon = GUICard.getIcon(LowCardGame.getHand(0).inspectCard(0));

      // Create each player's label to put on the playing area
      playedCardLabels[1] = new JLabel("You", JLabel.CENTER);   
      playedCardLabels[0] = new JLabel("Computer", JLabel.CENTER);
      playedCardLabels[1].setIcon(playerIcon);   
      playedCardLabels[0].setIcon(compIcon);

      // Make sure text is centered
      playedCardLabels[1].setHorizontalTextPosition(JLabel.CENTER);
      playedCardLabels[1].setVerticalTextPosition(JLabel.BOTTOM);
      playedCardLabels[0].setHorizontalTextPosition(JLabel.CENTER);
      playedCardLabels[0].setVerticalTextPosition(JLabel.BOTTOM);
      
      // Set the play area layout
      myCardTable.pnlPlayArea.setLayout(new GridLayout());
      
      // Remove old plays and add current plays
      myCardTable.pnlPlayArea.removeAll();
      myCardTable.pnlPlayArea.add(playedCardLabels[1]);
      /* add line to delay computers play */
      myCardTable.pnlPlayArea.add(playedCardLabels[0]);
      
      // Remove the card from the player panel
      myCardTable.pnlHumanHand.remove(cardButtons[cardNum]);
      myCardTable.pnlHumanHand.repaint();
      
      // Remove a label from the computer area
      myCardTable.pnlComputerHand.remove(computerLabels[0]);
      myCardTable.pnlComputerHand.repaint();
      
      myCardTable.setVisible(true);
   }

   private void testActionListener()
   {
      /************* Test action listener Method **************/
      
      //System.out.println("Pre sort: " + LowCardGame.getHand(0).toString());

      // Sort the computer's hand, in order to get the lowest card
      LowCardGame.getHand(0).sort();

      System.out.println("Computer hand Pre: " + LowCardGame.getHand(0).toString());
      System.out.println("Player hand Pre : " + LowCardGame.getHand(1).toString());

      // Add playing cards into an array 
      Card[] cardInPlay = new Card[2];
      cardInPlay[0] = LowCardGame.playCard(0, 0);
      cardInPlay[1] = LowCardGame.playCard(1, 0);

      System.out.println("Computer hand at Play: " + LowCardGame.getHand(0).toString());
      System.out.println("Player hand at play: " + LowCardGame.getHand(1).toString());

      // Display icon for player
      Icon playerIcon = GUICard.getIcon( cardInPlay[1]);
      System.out.println("Player Card: " +  cardInPlay[1]);
      playedCardLabels[1] = new JLabel("You", JLabel.CENTER);
      playedCardLabels[1].setIcon(playerIcon);
      playedCardLabels[1].setHorizontalTextPosition(JLabel.CENTER);
      playedCardLabels[1].setVerticalTextPosition(JLabel.BOTTOM);
      
      // Dispay icon for computer 
      Icon compIcon = GUICard.getIcon(cardInPlay[0]);
      System.out.println("Computer Card: " + cardInPlay[0]);
      playedCardLabels[0] = new JLabel("Computer", JLabel.CENTER);
      playedCardLabels[0].setIcon(compIcon);
      playedCardLabels[0].setHorizontalTextPosition(JLabel.CENTER);
      playedCardLabels[0].setVerticalTextPosition(JLabel.BOTTOM);

      // Set the play area layout
      myCardTable.pnlPlayArea.setLayout(new GridLayout());
     
      // add line to delay
      myCardTable.pnlPlayArea.add(playedCardLabels[0]);
      
      myCardTable.pnlPlayArea.add(playedCardLabels[1]);

      System.out.println("Computer's Card: " + cardInPlay[0].getValue());
      System.out.println("Player's Card: " + cardInPlay[1].getValue());

      // Check who won this round 
      if(cardInPlay[0].getValue() < cardInPlay[1].getValue())
      {
         // Computer wins this round
         compWinnings[computerWinningsCounter] = cardInPlay[0];
         compWinnings[computerWinningsCounter] = cardInPlay[1];
         computerWinningsCounter += 2;
      }
      else if(cardInPlay[0].getValue() > cardInPlay[1].getValue())
      {
         // Human wins this round
         humanWinnings[humanWinningsCounter] = cardInPlay[0];
         humanWinnings[humanWinningsCounter] = cardInPlay[1];
         humanWinningsCounter += 2;
      }   
      else
      {
         // If there is a tie
         // lets think about this later
      }
      
      //myCardTable.pnlPlayArea.removeAll();
      //myCardTable.pnlPlayArea.remove(playedCardLabels[0]);
      //myCardTable.pnlPlayArea.remove(playedCardLabels[1]);
      
      System.out.println("I'm done!");

      LowCardGame.takeCard(0);
      LowCardGame.takeCard(1);

      System.out.println("Computer hand post: " + LowCardGame.getHand(0).toString());
      System.out.println("Player hand post: " + LowCardGame.getHand(1).toString());

      /************************ END TEST ************************/
   }
}

/***** END OF PHASE 3 CLASS ***/

class Game implements ActionListener
{ 
   @Override
   public void actionPerformed(ActionEvent e) 
   {
      String cardPlayed = e.getActionCommand();
      int cardNum = Integer.parseInt(cardPlayed);
      Icon tempIcon = GUICard.getIcon(LowCardGame.getHand(1).inspectCard(cardNum));
      
      //Test
      /*
      if(cardPlayed.equals("0"))
         //myCardTable.pnlHumanHand.set
         System.out.println("Card 0");
      else if(cardPlayed.equals("1"))
         System.out.println("Card 1");
      else if(cardPlayed.equals("2"))
         System.out.println("Card 2");
      else if(cardPlayed.equals("3"))
         System.out.println("Card 3");
      else if(cardPlayed.equals("4"))
         System.out.println("Card 4");
      else if(cardPlayed.equals("5"))
         System.out.println("Card 5");
      else if(cardPlayed.equals("6"))
         System.out.println("Card 6");
      else
         System.out.println("Error");
     */
   }
}




/****************************************
 * CardGameFrameWork class
 *****************************************/
class CardGameFramework
{
   private static final int MAX_PLAYERS = 50;

   private int numPlayers;
   private int numPacks;            // # standard 52-card packs per deck
                                    // ignoring jokers or unused cards
   private int numJokersPerPack;    // if 2 per pack & 3 packs per deck, get 6
   private int numUnusedCardsPerPack;  // # cards removed from each pack
   private int numCardsPerHand;        // # cards to deal each player
   private Deck deck;               // holds the initial full deck and gets
                                    // smaller (usually) during play
   private Hand[] hand;             // one Hand for each player
   private Card[] unusedCardsPerPack;   // an array holding the cards not used
                                        // in the game.  e.g. pinochle does not
                                        // use cards 2-8 of any suit

   public CardGameFramework( int numPacks, int numJokersPerPack,
         int numUnusedCardsPerPack,  Card[] unusedCardsPerPack,
         int numPlayers, int numCardsPerHand)
   {
      int k;

      // filter bad values
      if (numPacks < 1 || numPacks > 6)
         numPacks = 1;
      if (numJokersPerPack < 0 || numJokersPerPack > 4)
         numJokersPerPack = 0;
      if (numUnusedCardsPerPack < 0 || numUnusedCardsPerPack > 50) //  > 1 card
         numUnusedCardsPerPack = 0;
      if (numPlayers < 1 || numPlayers > MAX_PLAYERS)
         numPlayers = 4;
      // one of many ways to assure at least one full deal to all players
      if  (numCardsPerHand < 1 ||
            numCardsPerHand >  numPacks * (52 - numUnusedCardsPerPack)
            / numPlayers )
         numCardsPerHand = numPacks * (52 - numUnusedCardsPerPack) / numPlayers;

      // allocate
      this.unusedCardsPerPack = new Card[numUnusedCardsPerPack];
      this.hand = new Hand[numPlayers];
      for (k = 0; k < numPlayers; k++)
         this.hand[k] = new Hand();
      deck = new Deck(numPacks);

      // assign to members
      this.numPacks = numPacks;
      this.numJokersPerPack = numJokersPerPack;
      this.numUnusedCardsPerPack = numUnusedCardsPerPack;
      this.numPlayers = numPlayers;
      this.numCardsPerHand = numCardsPerHand;
      for (k = 0; k < numUnusedCardsPerPack; k++)
         this.unusedCardsPerPack[k] = unusedCardsPerPack[k];

      // prepare deck and shuffle
      newGame();
   }

   // constructor overload/default for game like bridge
   public CardGameFramework()
   {
      this(1, 0, 0, null, 4, 13);
   }

   public Hand getHand(int k)
   {
      // hands start from 0 like arrays

      // on error return automatic empty hand
      if (k < 0 || k >= numPlayers)
         return new Hand();

      return hand[k];
   }

   public Card getCardFromDeck() { return deck.dealCard(); }

   public int getNumCardsRemainingInDeck() { return deck.getNumCards(); }

   public void newGame()
   {
      int k, j;

      // clear the hands
      for (k = 0; k < numPlayers; k++)
         hand[k].resetHand();

      // restock the deck
      deck.init(numPacks);

      // remove unused cards
      for (k = 0; k < numUnusedCardsPerPack; k++)
         deck.removeCard( unusedCardsPerPack[k] );

      // add jokers
      for (k = 0; k < numPacks; k++)
         for ( j = 0; j < numJokersPerPack; j++)
            deck.addCard( new Card('X', Card.Suit.values()[j]) );

      // shuffle the cards
      deck.shuffle();
   }

   public boolean deal()
   {
      // returns false if not enough cards, but deals what it can
      int k, j;
      boolean enoughCards;

      // clear all hands
      for (j = 0; j < numPlayers; j++)
         hand[j].resetHand();

      enoughCards = true;
      for (k = 0; k < numCardsPerHand && enoughCards ; k++)
      {
         for (j = 0; j < numPlayers; j++)
            if (deck.getNumCards() > 0)
               hand[j].takeCard( deck.dealCard() );
            else
            {
               enoughCards = false;
               break;
            }
      }

      return enoughCards;
   }

   void sortHands()
   {
      int k;

      for (k = 0; k < numPlayers; k++)
         hand[k].sort();
   }

   Card playCard(int playerIndex, int cardIndex)
   {
      // returns bad card if either argument is bad
      if (playerIndex < 0 ||  playerIndex > numPlayers - 1 ||
          cardIndex < 0 || cardIndex > numCardsPerHand - 1)
      {
         //Creates a card that does not work
         return new Card('M', Card.Suit.spades);      
      }
   
      // return the card played
      return hand[playerIndex].playCard(cardIndex);
   
   }


   boolean takeCard(int playerIndex)
   {
      // returns false if either argument is bad
      if (playerIndex < 0 || playerIndex > numPlayers - 1)
         return false;
     
       // Are there enough Cards?
       if (deck.getNumCards() <= 0)
          return false;

       return hand[playerIndex].takeCard(deck.dealCard());
   }

}