package assignments.uber.languageprocessor;

/**
 * The Language processor
 */
public class LanguageProcessor {

    public static Language train(String languageName, String corpus) {
        double[] letterFreq = getFreqTable(corpus);
        return new Language(languageName, letterFreq);
    }

    // Try this corpus (text file) against all languages
    public static Language classify(String corpus, Language[] languages) {
        // TODO
        return null;
    }

    // Construct the frequency table for some sample texts
    // Cont frequency for letters "abcdefghijklmnopqrstuvwxyz" in text
    public static double[] getFreqTable(String text) {
        // TODO
        return null;
    }


}
