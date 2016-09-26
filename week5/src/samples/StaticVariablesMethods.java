package samples;

import static java.lang.System.*;

/*
   Instance can use/call static but static not instance
 */
public class StaticVariablesMethods {

    private static int i;
    private int j;

    public void doIt() {
        out.println(i);
        out.println(j);
        this.doOther();
    }

    public static void doOther() {
        out.println(i);
        //out.println(j);  // Bad
        //this.doIt();     // Bad
    }

}
