package assignments.uber.languageprocessor;

import java.io.Serializable;
import java.util.Arrays;

/*
 *   Class representing some language
 */

// Must "implements serializable" to be able to write object to file
public class Language implements Serializable {


    // The letters counted when calculating frequencies
    public final static String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    // The name of the language
    private final String name;
    // The letter frequencies for this language
    private final double[] letterFreq;

    public Language(String name, double[] letterFreq) {
        this.name = name;
        this.letterFreq = letterFreq;
    }

    // The distance to some other language calculated as the sum of squared differences
    // (for the letter frequencies)
    public double dist(Language other) {
        // TODO
        return 0;
    }


    public String getName() {
        return name;
    }

    // This method will automatically be called when using out.prinltn()
    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", letterFreq=" + Arrays.toString(letterFreq) +
                '}';
    }


}
