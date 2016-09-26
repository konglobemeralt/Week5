package samples.filehandling;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

/*
   File handling

   NOTE: Will not work for text files in the Devanagri language
 */
public class FileService {

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

    public static void writeObject(String path, String fileName, Object object) throws IOException {
        // Use try with resources to ensure stream is closed
        try (FileOutputStream fileOut = new FileOutputStream(path + File.separator + fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(object);
        }
    }

    public static Object readObject(String path, String name) throws IOException,
            ClassNotFoundException {
        Object object;
        try (FileInputStream fileIn = new FileInputStream(path + name);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            object = in.readObject();
        }
        return object;
    }
}
