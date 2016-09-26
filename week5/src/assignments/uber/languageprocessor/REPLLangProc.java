package assignments.uber.languageprocessor;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Read eval print loop (i.e. command line user interface)
 *  for the LanguageProcessor
 *
 *  All IO and exception handling here
 *
 */
public class REPLLangProc {

    public static void main(String[] args) {
        new REPLLangProc().program();
    }

    private final Scanner scan = new Scanner(in);

    private void program() {
        boolean done = false;
        out.println("Welcome to LangProc!");
        while (!done) {
            out.print("> ");
            String cmd = scan.nextLine();
            switch (cmd) {
                case "t":
                    // TODO train the program by reading multiple files in some language
                    // and create language objects (and serialize them to file for later use)
                    break;
                case "c":
                    // TODO classify test from a file using all known languages
                    // read all serialized languages and use them
                    break;
                case "k":
                    try {
                        Language[] knownLanguages = getKnownLanguages();
                        plot(knownLanguages);
                    } catch (IOException | ClassNotFoundException e) {
                        out.println(e.getMessage());
                    }
                    break;
                case "f":
                    // forget()  delete all .ser files.
                case "q":
                    done = true;
                    break;
                default:
                    out.println("?");
            }
        }
        out.println("Program terminated");
    }


    // -------- Below this IO methods (nothing to do) ------------------------

    // Write a language to disk (it will then be a "known" language)
    private void save(String path, String fileName, Language language) throws IOException {
        FileService.writeObject(path, fileName, language);
    }

    // Append a number of text files to one single (looong) string, the corpus
    private String createCorpus(String[] files, String directoryPath, String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        for (String file : files) {
            sb.append(FileService.readFromFile(directoryPath, fileName));
        }
        return sb.toString();
    }

    private String getLanguageName() {
        out.print("Enter language name > ");
        return scan.nextLine();
    }

    private String[] getFileNames(String msg) {
        out.print(msg);
        String files = scan.nextLine();
        return files.split(" ");
    }

    private Language[] getKnownLanguages() throws IOException, ClassNotFoundException {
        return FileService.getLanguages();
    }

    private void plot(Language[] languages) {
        for (Language l : languages) {
            out.println(l.getName());
        }
    }
}
