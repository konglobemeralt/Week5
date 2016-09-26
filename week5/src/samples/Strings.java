package samples;

import static java.lang.System.*;

/**
 * Basic about String
 */
public class Strings {

    public static void main(String[] args) {
        new Strings().program();
    }

    private void program() {
        testObjects();
        //testReferences();
        //testEquality();
        //testConversion();
    }

    private void testObjects() {
        String s1 = "True";
        String s2 = "True";                 // s1 == s2?
        String s3 = new String("False");
        String s4 = new String("False");    // s3 == s4?
        String s5 = "True";
        String s6 = "Tr" + "ue";           // s5 == s6?
        String s7 = "False";
        String sx = "F";
        String s8 = sx + "alse";           // s7 == s8?
    }

    private void testReferences() {
        String s1 = "abcdef";
        String s2 = "abcdef";

        out.println(s1 == s2);
        String s3 = s1 + "";
        out.println(s1 != s3);    // Objects not the same ...
        out.println(s1.intern() == s3.intern()); // .. but data the same

        String s4 = new String("abcdef ");   // Bad, don't use new with strings, extra object created
        out.println(s1 != s4);

    }

    private void testEquality() {
        String s1 = "abcdef";
        String s2 = new String(s1); // Bad, don't use new with strings, extra object created

        out.println(s1 != s2);
        out.println(s1.equals(s2));  // Must use equals if comparing content

        out.println(lineSeparator().equals("\n")); // For Unix/Linux this is true

        String s3 = "olle";
        String s4 = "fia";

        out.println(s3.compareTo(s4) != 0);  // Not equal
        out.println(s3.compareTo(s4) < 0);  // fia is smaller in lexicographical order
        out.println(s4.compareTo(s3) > 0);  // olle is bigger in lexicographical order
    }

    private void testConversion() {
        int i = 4;
        Double d = 4.5;

        String s1 = String.valueOf(i);  // Inverse of Integer.valueOf()
        String s2 = String.valueOf(d);

        String s3 = "abcdefghijklmnoprs";
        char[] chars = s3.toCharArray();   // Convert to char array
        for (char ch : chars) {
            out.print(ch + " ");
        }
        out.println();
        out.println(String.valueOf(chars));  // Convert back to String

        String s4 = String.valueOf(s3);   // Convert back to String
        out.print(s4);
    }



}
