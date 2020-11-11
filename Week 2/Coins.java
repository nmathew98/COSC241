package week02;
/** Coins app from Lab 2.
  * @author Naveen Mathew
  */
import java.util.Random;

/** Coins class.
  * @author Naveen Mathew
  */
public class Coins{

    /** HEADS data field will represent a true.
      * @author Naveen Mathew
      */
    public static final boolean HEADS = true;
    /** TAILS data field will represent a false.
      * @author Naveen Mathew
      */
    public static final boolean TAILS = false;
    /** coins data field will hold our variouns coins.
      * @author Naveen Mathew
      */
    private boolean[] coins;

    /** Coins constructor.
      * @param coins Acceps a boolean array called coins and
      *              assigns the data field to it
      * @author Naveen Mathew
      */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    /** Coins constructor.
      * @param c Accepts a string of format 'HTHT',
      *          'H' for heads and 'T' for tails
      * @author Naveen Mathew
      */
    public Coins(String c) {
        int i = 0;
        coins = new boolean[c.length()];

        for (char s : c.toCharArray()) {
            coins[i] = s == 'H' ? HEADS : TAILS;
            i++;
        }
    }

    /** Coins constructor.
      * @param length Accepts an integer that specifies the length of a
      *               new coins array to create, with values assigned randomly
      * @author Naveen Mathew
      */
    public Coins(int length) {
        coins = new boolean[length];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            coins[i] = rand.nextInt(2) == 0 ? TAILS : HEADS;
        }
    }

    /** Our main method.
      * @param args Accepts arguments from the command line, not really needed.
      * @author Naveen Mathew
      */
    public static void main(String[] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        Coins d = new Coins("HTHHH");
        Coins e = new Coins(5);
        Coins f = new Coins("HHTHHHTTT");

        System.out.println(c.countHeads());
        System.out.println(c.toString() + " " + c.countRuns());
        System.out.println(d.toString() + " " + d.countRuns());
        System.out.println(e.toString() + " " + e.countRuns());
        System.out.println(f.countRuns());
    }

    /** Counts the number of heads in a sequence of coins.
      * @return Returns the number of heads in the coins sequence.
      * @author Naveen Mathew
      */
    public int countHeads() {
        int numberOfHeads = 0;
        for (boolean coin : coins) {
            numberOfHeads += coin == HEADS ? 1 : 0;
        }
        return numberOfHeads;
    }

    /** Couns the number of runs in a sequence of coins.
      * A run is a consecutive number of heads or tails.
      * @return Returns the number of runs in the coins sequence.
      * @author Naveen Mathew
      */
    public int countRuns() {
        int runs = 0;
        for (int i = 0; i < coins.length - 1; i++) {
            runs += coins[i] == coins[i+1] ? 0 : 1;
        }
        runs++;
        // Increment by one because if the last coin a part of a run
        //it doesn't increment and if it isnt
        // it doesnt increment otherwise to account for the extra run

        return runs;
    }

    /** toString method just converts our array of booleans to words.
      * @return Retuns a string of our coins sequence
      * @author Naveen Mathew
      */
    public String toString() {
        String s = "";
        for (boolean coin : coins) {
            s += coin == HEADS ? "H" : "T";
        }
        return s;
    }

}
