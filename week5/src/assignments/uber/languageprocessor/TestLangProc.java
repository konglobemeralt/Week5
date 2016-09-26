package assignments.uber.languageprocessor;

import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.System.out;

/**
 * Test for the Language processor
 * -
 */
public class TestLangProc {

    public static void main(String[] args) {
        new TestLangProc().test();
    }

    private void test() {
        // All should print true
        testLanguageDistance();
        testFileServiceReadTextFile();
        testFileServiceReadAndSaveLanguage();
    }

    private void testLanguageFreq() {
        /// TODO
    }


    // Not much of a test, U add something smart... (optional)
    private void testLanguageDistance() {
        String dummyCorpus = "aabbssshhhwwwrrrrtjjjjtttlllllldddttt";
        double[] letterFreq = LanguageProcessor.getFreqTable(dummyCorpus);
        Language l1 = new Language("l1", letterFreq);
        Language l2 = new Language("l2", letterFreq);
        out.println(l1.dist(l2) == 0);
    }

    private void testFileServiceReadTextFile() {
        String[] text = null;
        try {
            text = FileService.readFromFile(FileService.CORPUS_PATH, "fr1.txt");
            String s = text[0].substring(0, text[0].indexOf(","));
            out.println(s.equals("L'aspergillome"));

            text = FileService.readFromFile(FileService.CORPUS_PATH, "port1.txt");
            s = text[0].substring(0, text[0].indexOf(" "));
            out.println(s.equals("\"Government"));  // Must escape " i.e. add \ before, lite this \"

        } catch (FileNotFoundException e) {
            out.println("FileNotFoundException " + e.getMessage());
        }
    }

    private void testFileServiceReadAndSaveLanguage() {
        double[] dummyFreq = new double[0];
        try {
            Language l1 = new Language("dummy", dummyFreq);
            FileService.writeObject(FileService.LANGUAGE_PATH, l1.getName() + ".ser", l1);
            // writeLanguage will add suffix .ser
            Language l2 = FileService.readObject(FileService.LANGUAGE_PATH, l1.getName() + ".ser");
            out.println(l2.getName().equals(l1.getName()));
            out.println(l1 != l2);
        } catch (IOException e) {
            out.println("IOException " + e.getMessage());
        } catch (ClassNotFoundException e) {
            out.println("ClassNotFoundException " + e.getMessage());
        }

    }


}
