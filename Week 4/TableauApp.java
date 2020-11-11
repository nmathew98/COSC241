package week04;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Naveen Mathew
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
    }

    /**
     * Checks that no row is longer than a preceding row.
     * @param t takes a tableau array as input
     * @return Returns true if no row is longer than a preceding row
     */
    public static boolean rowLengthsDecrease(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            if (i != t.length - 1 && t[i].length < t[i+1].length) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if integers are increasing from top to bottom in any column.
     * @param t takes a tableau array as input
     * @return Returns true if integers are increasing from top to bottom
     */
    public static boolean columnValuesIncrease(int[][] t) {
        for(int row = 0; row < t.length && row != t.length - 1; row++) {
            for(int column = 0; column < t[row].length; column++) {
                if (column < t[row+1].length) {
                    if (t[row][column] > t[row+1][column]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Finds the range of numbers in our array.
     * @param t takes a tableau array as input
     * @return Returns an array containing the lowest and highest
     *         numbers found and the number of cells.
     */
    public static int[] rangeOfTableau(int[][] t) {
        int minimumValue = t[0][0];
        int maximumValue = t[0][0];
        int numberOfCells = 0;
        for (int row = 0; row < t.length; row++) {
            numberOfCells += t[row].length;
            for (int column = 0; column < t[row].length; column++) {
                if (t[row][column] < minimumValue) {
                    minimumValue = t[row][column];
                }
                if (t[row][column] > maximumValue) {
                    maximumValue = t[row][column];
                }
            }
        }
        return new int[] {minimumValue, maximumValue, numberOfCells};
    }

    /**
     * Check for duplicate entries in array.
     * @param t takes a tableau array as input
     * @return Returns if there is a duplicate
     */
    public static boolean areThereDuplicates(int[][] t) {
        int numberOfCells = 0;
        int sumOfInputs = 0;
        int[] rangeOfInput = rangeOfTableau(t);
        int expectedSum = (rangeOfInput[1]*(rangeOfInput[1] + 1))/2;
        for (int row = 0; row < t.length; row++) {
            numberOfCells += t[row].length;
            for (int column = 0; column < t[row].length; column++) {
                sumOfInputs += t[row][column];
            }
        }
        return sumOfInputs == expectedSum;
    }

    /**
     * Checks the numbers in our Tableau array.
     * @param t takes a tableau array as input
     * @return Returns true if it fits our requirements
     */
    public static boolean isSetOf1toN(int[][] t) {
        int[] rangeOfValues = rangeOfTableau(t);
        //System.out.println(areThereDuplicates(t));
        //System.out.println(rangeOfValues[1]);
        //System.out.println(rangeOfValues[2]);
        return areThereDuplicates(t) && rangeOfValues[1] == rangeOfValues[2];
    }

    /**
     * Checks that the integers in each row are increasing from left to right.
     * @param t takes a tableau array as input
     * @return Returns true if the integers in each row are increasing
     */
    public static boolean rowValuesIncrease(int[][] t) {
        for (int row = 0; row < t.length && row != t.length - 1; row++) {
            for (int index = 0; index < t[row].length; index++) {
                if (index != t[row].length - 1) {
                    if (t[row][index] > t[row][index+1]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t) {
        if (rowLengthsDecrease(t)) {
            if (rowValuesIncrease(t)) {
                if (columnValuesIncrease(t)) {
                    if (isSetOf1toN(t)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

}
