package samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

/*
   Using a short for loop. USE FOR READ ONLY

   Use if no need for an index
 */
public class ShortForLoop {

    public static void main(String[] args) {
        new ShortForLoop().program();
    }

    private void program() {
        int[] is = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] iis = {1, 2, 3};
        String strs[] = {"a", "b", "c", "d", "e", "f"};

        for (int i : is) {  // NOTE: No index just each element in order
            out.print(i);
        }
        out.println();
        for (String s : strs) {
            out.print(s);
        }
        out.println();

        // Bad can't assign
        for (String s : strs) {
            out.print(s);
            s = "X";       // s is a local variable. If assigned will not affect original array element
            out.print(s);
        }
        out.println();
        out.println(Arrays.toString(strs));
    }

}
