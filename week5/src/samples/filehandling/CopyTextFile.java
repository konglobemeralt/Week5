package samples.filehandling;

import java.io.FileNotFoundException;

/**
 * Program to copy a file.
 */
public class CopyTextFile {

    public static void main(String[] args) {
        new CopyTextFile().program();
    }

    // Primitive but we don't know List<> yet
    private String[] buffer;
    private int position;


    private void program() {
        //out.println(File.separator);
        copy("./src/samples/filehandling", "junk.txt","./src/samples/filehandling", "copyofjunk,txt" );
    }

    public void copy(String path1, String source, String path2, String dest){
        try {
            String[] content = FileService.readFromFile(path1, source);
           FileService.writeToFile(path2, dest, content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
