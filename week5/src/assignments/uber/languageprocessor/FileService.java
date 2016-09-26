package assignments.uber.languageprocessor;

import samples.filehandling.MyClass;

import java.io.*;
import java.util.Scanner;

/*
   File handling (nothing to do here)

   NOTE: Will not work for text files in the Devanagri language
 */
public class FileService {

    // Constants possibly to be used by other objects
    public final static String CORPUS_PATH = "src/assignments/uber/languageprocessor/corpus/";
    public final static String LANGUAGE_PATH = "src/assignments/uber/languageprocessor/lang/";
    public final static String TEST_PATH = "src/assignments/uber/languageprocessor/test/";

    // Can't instantiate
    private FileService(){}

    // Use Devanagri letter A as delimiter (fix to avoid use of buffer or other stuff)
    private static final char DELIMITER = '\u0905';

    public static String[] readFromFile(String path, String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File(path + File.separator + fileName);
        // Use try with resources to ensure the Scanner is closed
        try (Scanner sc = new Scanner(file)) {
            int i = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.length() > 0) {
                    sb.append(line).append(DELIMITER);
                }
            }
        }
        String delimiter = "" + DELIMITER;
        return sb.toString().split(delimiter);
    }

    public static void writeToFile(String path, String fileName, String[] lines) throws FileNotFoundException {
        File f = new File(path + File.separator + fileName);
        try (PrintWriter out = new PrintWriter(f)) {
            for (String line : lines) {
                out.println(line);
            }
        }
    }

    public static void writeObject(String path, String fileName, Language language) throws IOException {
        // Use try with resources to ensure stream is closed
        try (FileOutputStream fileOut = new FileOutputStream(path + File.separator + fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(language);
        }
    }

    public static Language readObject(String path, String name) throws IOException,
            ClassNotFoundException {
        Language object;
        try (FileInputStream fileIn = new FileInputStream(path + name);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            object = (Language) in.readObject();
        }
        return object;
    }

    // List all known languages = all .ser files
    public static Language[] getLanguages() throws IOException, ClassNotFoundException {
        File langDir = new File(LANGUAGE_PATH);
        File[] files = langDir.listFiles();
        Language[] langs = new Language[files.length];
        int i = 0;
        for (File f : files) {
            langs[i++] = (Language) readObject(LANGUAGE_PATH, f.getName());
        }
        return langs;
    }
}
