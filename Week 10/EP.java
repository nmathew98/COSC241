package week10;

import java.util.*;
import java.util.stream.*;

/**
 * Where all the main logic lives for our Exam application.
 *
 * The problem: To implement an interface to a data structure that supports
 *              O(1) time complexity when adding, examing or deleting an
 *              element at either end of the data structure. The size of
 *              the data structure remains the same throughout as no new
 *              elements are added once the elements are loaded. However,
 *              there are operations which move the first element to the bottom.
 *
 * The implementation: An ArrayDeque has been used to implement the program.
 *                     An ArrayDeque has O(1) time complexity when adding,
 *                     examining or deleting an element at either end and
 *                     is generally faster than a Stack and generally faster
 *                     than a LinkedList for queue operations. It also
 *                     implements Iterable so it can be traversed using
 *                     a foreach loop or iterator. As we are only accessing
 *                     elements at the ends in the program, the ArrayDeque
 *                     is a suitable data structure to use for our needs.
 *
 * Sources: - https://www.leepoint.net/data/collections/deques/arraydeque.html
 *          - Java API
 *
 * @author Naveen Mathew
 */
public class EP implements ExamPile {

    /**
     * Stores our list of papers to grade.
     */
    private Deque<Integer> items = new ArrayDeque<>();

    /**
     * Default constructor.
     * Accepts no parameters and does not return any values
     */
    public EP() {}

    /**
     * Initiates a new EP object and loads the pile of papers.
     * @param items the pile of papers to grade
     */
    public EP(int[] items) {
        load(items);
    }

    /**
     * Checks if there is anything in the pile of papers.
     * @throws EmptyPileException if our pile is empty
     */
    private void isEmpty() throws EmptyPileException {
        if (items.isEmpty()) {
            throw new EmptyPileException("Exam pile cannot be empty!");
        }
    }

    /**
     * Loads the pile of papers to grade.
     * Adds each paper in the pile to an ArrayDeque
     * @param items the pile of papers to grade
     */
    public void load(int[] items) {
        this.items = Arrays.stream(items).boxed()
                           .collect(Collectors.toCollection(ArrayDeque::new));
    }

    /**
     * Determines the number of papers in the pile.
     * @return the size of the pile
     */
    public int size() {
        return this.items.size();
    }

    /**
     * Peeks at the top of the pile.
     * @throws EmptyPileException if our pile is empty
     * @return returns the first item on the pile
     */
    public int peek() throws EmptyPileException {
        isEmpty();
        return this.items.peek();
    }

    /**
     * Marks the paper at the top of the pile.
     * When a paper is marked, it is removed from the list,
     * and the value associated with it is returned.
     * @throws EmptyPileException if our pile is empty
     * @return the value at the top of the pile.
     */
    public int mark() throws EmptyPileException {
        isEmpty();
        return this.items.pop();
    }

    /**
     * Delays the marking of a paper.
     * Moves the paper at the top of the pile to the bottom
     * @throws EmptyPileException if our pile is empty
     */
    public void delay() throws EmptyPileException {
        isEmpty();
        this.items.add(this.items.pop());
    }

    /**
     * Compares the contents of two piles.
     * Checks the toStrings of both piles to see if they match
     * @param secondPile the pile of paper to compare with
     * @return true if the piles have the same contents
     */
    public boolean equals(EP secondPile) {
        return this.toString().equals(secondPile.toString());
    }

    /**
     * Returns a string representation of our pile.
     * @return a string representation of our pile
     */
    public String toString() {
        return this.items.stream()
                         .map(i -> Integer.toString(i))
                         .collect(Collectors.joining(" "));
    }

    /**
     * Determines the steps we need to take to finish grading our pile.
     * 'D' means to delay the paper at the top of the pile
     * 'M' means to mark the paper at the top of our pile
     * Basically arranges our pile in ascending order progressively and
     * marks it
     * @return a string representing the steps we need to take to finish grading
     */
    public String sortingSteps() {
        String sortingSeq = "";

        try {
            int i = 0;
            while (this.items.size() != 0) {
                if (this.items.peek() != i) {
                    sortingSeq += "D";
                    delay();
                } else if (this.items.peek() == i) {
                    sortingSeq += "M";
                    mark();
                    i++;
                }
            }
        } catch (EmptyPileException ex) {
            System.out.println(ex.getMessage());
        }

        return sortingSeq;
    }

    /**
     * Reconstruct a pile from the steps taken to mark it.
     * Basically reverses the sortingSteps() method
     * The way it works is:
     *  - First get the number of elements in our pile
     *  - If the step is 'M' then add the last value from our
     *    ordered elements array to the top of our list
     *  - If the step is 'D' then move the value at the bottom
     *    of the pile to the top of the pile
     * @param steps the steps taken to mark a pile of papers
     * @return an EP object with the reconstructed pile loaded
     */
    static EP reconstruct(String steps) {
        char[] stepsArray = steps.toCharArray();
        Deque<Integer> unsorted = new ArrayDeque<>();

        int numberOfElements = Math.toIntExact(steps.chars()
                                                    .filter(c -> c == 'M')
                                                    .count()) - 1;

        for (int i = stepsArray.length - 1; i > -1; i--) {
            if (stepsArray[i] == 'M') {
                unsorted.addFirst(numberOfElements);
                numberOfElements--;
            }
            if (stepsArray[i] == 'D') {
                unsorted.addFirst(unsorted.removeLast());
            }
        }

        return new EP(unsorted.stream()
                              .mapToInt(i->i)
                              .toArray());
    }
}
