package week07;

import java.util.*;
import java.io.File;

/**
 * DigramGenerator. A better word generator.
 * @author Naveen Mathew
 */
public class DigramGenerator implements WordGenerator {
    /**
     * Points to our random number generator.
     */
    private Random random;

    /**
     * Constructor method.
     * @param r random number generator
     */
    public DigramGenerator(Random r) {
        random = r;
    }

    /**
     * Makes a random word.
     * @param n length of words
     * @return a random word
     */
    public String nextWord(int n) {
        String firstLetters = "";
        String[] continuations = new String[Integer.valueOf("26")];

        try {
            File firstLettersFile = new File("first-letters.txt");
            File continuationsFile = new File("continuations.txt");
            Scanner firstLettersScanner = new Scanner(firstLettersFile);
            Scanner continuationsScanner = new Scanner(continuationsFile);

            firstLetters = firstLettersScanner.nextLine();
            for (int i = 0; continuationsScanner.hasNextLine(); i++) {
                continuations[i] = continuationsScanner.nextLine();
            }

            firstLettersScanner.close();
            continuationsScanner.close();
        } catch (Exception ex) {
            System.out.println("Files not found!");
        }

        StringBuilder result = new StringBuilder();
        int firstLetterPos = random.nextInt(firstLetters.length());
        char firstLetter = firstLetters.charAt(firstLetterPos);
        result.append(firstLetter);
        for (int i = 1; i < n; i++) {
            char previousLetter = result.charAt(i - 1);
            int corrLettersPos = previousLetter - 'a';
            String correspondingLetters = continuations[corrLettersPos];

            int nextLetterPos = random.nextInt(correspondingLetters.length());
            char nextLetter = correspondingLetters.charAt(nextLetterPos);
            result.append(nextLetter);
        }
        return result.toString();
    }
}
