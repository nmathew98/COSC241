package week10;

import java.util.*;

/**
 *  Application class for the 241 assignment.
 *
 *  Due: 4pm Friday May 10th 2019.
 *
 * @author Naveen Mathew
 */
public class ExamApp {

    /**
     *  Creates an EP instance and reads lines of input from stdin to be
     *  handled by processLine().
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        EP pile = new EP();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            try {
                processLine(pile, input.nextLine());
            } catch (EmptyPileException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  Processes commands from the given line and executes actions on
     *  pile.  Available commands are:
     * <pre>
     *  load - read integers into an array and send to load method.
     *  peek - print the first exam in pile.
     *  mark - remove and print the first exam in pile.
     *  delay - move the first exam to the bottom of pile.
     *  sortingsteps - print the result of calling sortingSteps().
     *  reconstruct - print pile reconstructed from M's + D's string.
     *  compare - compare the pile with a new pile produced by calling
                  sortingSteps() then reconstruct().
     *  view - print out the pile.
     * </pre>
     * @param pile a pile of exams to operate on.
     * @param line a line containing commands and arguments.
     * @throws EmptyPileException if peek, mark, or delay are performed
     *         on an empty pile.
     */
    public static void processLine(EP pile, String line)
        throws EmptyPileException {
        Scanner input = new Scanner(line);
        while (input.hasNext()) {
            String command = input.next().toLowerCase();
            switch (command) {
                case "l": case "load":
                    ArrayList<Integer> list = new ArrayList<>();
                    while (input.hasNextInt()) {
                        list.add(input.nextInt());
                    }
                    int[] nums = new int[list.size()];
                    for (int i = 0; i < nums.length; i++) {
                        nums[i] = list.get(i);
                    }
                    pile.load(nums);
                    break;
                case "p": case "peek":
                    System.out.println("peek: " + pile.peek());
                    break;
                case "m": case "mark":
                    System.out.println("mark: " + pile.mark());
                    break;
                case "d": case "delay":
                    pile.delay();
                    break;
                case "s": case "sortingsteps":
                    System.out.println(pile.sortingSteps());
                    break;
                case "r": case "reconstruct":
                    if (input.hasNext()) {
                        System.out.println(EP.reconstruct(input.next()));
                    }
                    break;
                case "c": case "compare":
                    String steps = pile.sortingSteps();
                    EP pile2 = EP.reconstruct(steps);
                    String steps2 = pile2.sortingSteps();
                    System.out.printf("%s (pile) = %s (pile2) %s\n", steps,
                                      steps2, pile.equals(pile2));
                    break;
                case "v": case "view":
                    System.out.println(pile);
                    break;
                default:
                    System.err.println("Unknown command: " + command);
            }
        }
    }
}
