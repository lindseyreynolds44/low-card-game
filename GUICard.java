/****************************************************************
 * GUI Card
 * 
 * description:  creates a new GUICard class 
 * usage:        manages the reading and building of the card
 *               image Icons.
 *****************************************************************/
public class GUICard
{
   //members to facilitate GUICard class 
   private static Icon[][] iconCards = new ImageIcon[14][4]; 
   private static Icon iconBack;
   static boolean iconsLoaded = false;

   //identifies card icon filenames 
   private static char[] cardSuits = {'C', 'D', 'H', 'S'};
   /**
    * generates the image icon array from files 
    */
   static void loadCardIcons()
   {
      if(iconsLoaded)
         return;

      //generates file names of icon and adds to Icon's array
      String filename = "";
      for (int i = 0; i < Card.valuRanks.length; ++i)
      {
         for (int j = 0; j < cardSuits.length; ++j)
         {
            filename = "images/" + Card.valuRanks[i] + cardSuits[j]
               + ".gif";
            iconCards[i][j] = new ImageIcon(filename);
         }
      }
      //fills the back of card
      iconBack = new ImageIcon("images/BK.gif");
      iconsLoaded = true;
   }

      //returns back icon for back of card
      public static Icon getBackCardIcon()
      {
         loadCardIcons();
         return iconBack;
      }

      //returns specific icon 
      public static Icon getIcon(Card card)
      {
         loadCardIcons();
         return iconCards[valueAsInt(card)][suitAsInt(card)];
      }

      //index of card value returned 
      private static int valueAsInt(Card card)
      {
         int i = 0;
         while (card.getValue() != Card.valuRanks[i])
            ++i;

         return i;
      }

      //returns index of card suit 
      private static int suitAsInt(Card card)
      {
         int i;
         Card.Suit suit = card.getSuit();
         Card.Suit[] allSuits = Card.Suit.values();

         for (i = 0; i < allSuits.length; ++i)
            if (suit == allSuits[i])
               return i;
         
         //invalid suit
         return -1;
      }

   }
