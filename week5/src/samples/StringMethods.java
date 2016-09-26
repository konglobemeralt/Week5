package samples;

import static java.lang.System.out;

/**
 * Some usable methods
 *
 * Yuo don't need to learn this for the exam, if
 * needed you'll get the methods you need
 */
public class StringMethods {

    public static void main(String[] args) {
        new StringMethods().program();
    }

    private void program() {
        //testInspecting();
        testSearch();
        //testManipulate();
    }

    // Inspecting a string
    private void testInspecting() {
        String str = "abcdef";

        // Inspecting a string
        out.println(str.isEmpty());
        out.println(str.length());
        out.println(str.charAt(3));
        out.println(str.indexOf('a'));
        out.println(str.indexOf('X'));     // Not found -1

    }

    // Search inside a string
    private void testSearch() {
        String str = "abcdefabcdef";

        out.println(str.contains("cd"));
        out.println(str.startsWith("abc"));
        out.println(str.endsWith("def"));

        out.println(str.lastIndexOf("a"));
        // This uses a regular expression, a pattern to match
        // . = any char
        // * = zero or more times
        out.println(str.matches(".*fab.*"));

    }

    // Change string (will create new strings, string immutable)
    private void testManipulate() {
        String str = "Success consists of going from failure" +  // Multi line string
                " to failure without loss of enthusiasm";

        out.println(str.replace("failure", "icecream"));
        out.println(str.replaceFirst("failure", "icecream"));

        out.println("abcdef".substring(0, 4));  // NOTE: 0-3
        out.println("abcdef".substring(4)); // NOTE: 4-length

        out.println("   abcde    ".trim().equals("abcde"));  // Remove space

        String[] strs = str.split(" ");
        for( String s : strs){
            out.println( s );
        }

    }


}
