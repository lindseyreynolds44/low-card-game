
/*********************************************************************
 * CardTable
 * 
 * description:  creates CardTable class that extends JFrame
 * usage:        controls the positioning of the panels and 
 *               cards of the GUI
 **********************************************************************/

 public class CardTable extends JFrame
{
   private static final long serialVersionUID = 1L;
   // members establish the grid layout for the JPanels
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
      //displays title on window 
      super(title);

      //lays out the border 
      setLayout(new BorderLayout());

      //values that will be used 
      this.numCardsPerHand = numCardsPerHand;
      this.numPlayers = numPlayers;

      //field panels defined 
      pnlComputerHand = new JPanel(new GridLayout(1, numCardsPerHand));
      pnlHumanHand = new JPanel(new GridLayout(1, numCardsPerHand));
      pnlPlayArea = new JPanel(new GridLayout(2, numPlayers));

      //place panels on grid 
      add(pnlPlayArea, BorderLayout.CENTER);
      add(pnlComputerHand, BorderLayout.NORTH);
      add(pnlHumanHand, BorderLayout.SOUTH);

      //labels the borders 
      pnlPlayArea.setBorder(new TitledBorder("Community"));
      pnlComputerHand.setBorder(new TitledBorder("Opponent"));
      pnlHumanHand.setBorder(new TitledBorder("You"));


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