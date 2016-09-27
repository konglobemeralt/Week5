package assignments.product;

import assignments.uber.languageprocessor.Language;
import sun.misc.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * File handling for Hangman
 *
 * This doesn't represent some concept, it's just pure functionality, like Math class.
 * This should be a purely static class (no mutable state, not possible to instantiate)
 */
public class FileService {

    // The path to file words.txt
    public final static String WORD_PATH = "src/assignments/product/";

    // No instances
    private FileService() {
    }

    // Read a text file from some directory (we will read words.txt)
    public static String[] readFile(String path, String fileName) throws FileNotFoundException {
       // TODO
        Scanner in = new Scanner(new FileReader(path + fileName));
        ArrayList<String> stringArrayList = new ArrayList<String>();
        while (in.hasNext()) {
            stringArrayList.add(in.next());
        }

        return stringArrayList.stream().toArray(String[]::new);
    }
}
