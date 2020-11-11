package week03;

/**
  * App to calculate the number of digits and the sum of digits in a number.
  * @author Naveen Mathew
  */
public class RecursiveApp {
    /**
      * Counts the number of digits in a number.
      * If our number is less than 10, there is only 1 digit
      * If not we recursively process our number, taking off a digit each time
      * @param n Takes a long to process
      * @return Returns the number of digits in the input
      * @author Naveen Mathew
      */
    public static long digits(long n) {
        return n < 10 ? 1 : 1 + digits(n/10);
    }

    /**
     * Returns the sum of digits in a number.
     * If n = 0 then return 0
     * If not take the modulus of n to get the last digit, divide by 10
     * to remove the last digit and repeat until we are done.
     * @param n Takes a long to process
     * @return Returns the sum of the digits in the input
     * @author Naveen Mathew
     */
    public static long sumOfDigits(long n) {
        return n == 0 ? 0 : (n % 10) + sumOfDigits(n/10);
    }
}
