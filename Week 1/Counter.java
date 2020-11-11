/**
  * Week 1 application to count lines and words.
  * @author Naveen Mathew
  * @param args Takes an input
  * @return Returns an output of the number of lines and words
  */
package week01;

import java.util.*;
import java.io.*;

/**
  * Counter class.
  * @author Naveen Mathew
  */
public class Counter {
    /**
      * Main Method.
      * @author Naveen Mathew
      * @param args Takes an input
      */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineCount = 0;
        int wordCount = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineCount++;

            String str[] = line.split((" "));
            for (int i = 0; i < str.length; i++) {
                if (str[i].length() > 0) {
                    wordCount++;
                }
            }
        }

        System.out.println("lines: " + lineCount);
        System.out.println("words: " + wordCount);
    }
}
