package week10;

import java.util.*;

/**
 * Specfies the interface for our ExamApp.
 * @author Naveen Mathew
 */
public interface ExamPile {
    /**
     * Initializes the pile of exams.
     * @param items takes an array representing the exams in order
                    from top to bottom of the pile
     */
    public void load(int[] items);

    /**
     * Gets the number of exams in the pile.
     * @return the number of exams in the pile
     */
    public int size();

    /**
     * Peeks (gets the value) at the top of the pile.
     * @throws EmptyPileException if our pile is empty
     * @return the value (representing a paper) at the top of our pile
     */
    public int peek() throws EmptyPileException;

    /**
     * Returns the value at the top of the pile and removes it.
     * @throws EmptyPileException if our pile is empty
     * @return the value (representing a paper) at the top of our pile
     */
    public int mark() throws EmptyPileException;

    /**
     * Moves the value from the top of the pile to the bottom.
     * @throws EmptyPileException if our pile is empty
     */
    public void delay() throws EmptyPileException;
}
