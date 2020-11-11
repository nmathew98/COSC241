package week07;

import java.util.*;
import java.io.File;

/**
 * FrequencyGenerator class.
 * Generates words based on the frequency of the letters being used in words
 * @author Naveen Mathew
 */
public class FrequencyGenerator implements WordGenerator {

    /**
     * Random data field. Points to our random number generator.
     */
    private Random random;

    /**
     * Constructor for the class.
     * @param r Our random number generator
     */
    public FrequencyGenerator(Random r) {
        this.random = r;
    }

    /**
     * Chooses a random index based on weights.
     * @param w Our array of weights
     * @return Returns our random index
     */
    public int chooseIndex(double[] w) {
        int i = 0;
        double r = random.nextDouble();
        while (r > w[i]) {
            r = r - w[i];
            i++;
        }
        return i;
    }

    /**
     * Creates a random word.
     * @param n The length of the word we want
     * @return Returns a word of length n
     */
    public String nextWord(int n) {
        double[] letterFrequencies = new double[Integer.valueOf("26")];

        try {
            Scanner s = new Scanner(new File("letter-frequencies.txt"));
            for (int i = 0; s.hasNextDouble(); i++) {
                letterFrequencies[i] = s.nextDouble();
            }
            s.close();
        } catch (Exception ex) {
            System.out.println("Could not locate letter frequencies file!");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = (char) ('a' + chooseIndex(letterFrequencies));
            result.append(c);
        }

        return result.toString();
    }

}
