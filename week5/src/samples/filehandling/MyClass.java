package samples.filehandling;

import java.io.Serializable;

/**
 * Dummy class used for binary file IO
 */

public class MyClass implements Serializable {
    private String name;

    public MyClass(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

