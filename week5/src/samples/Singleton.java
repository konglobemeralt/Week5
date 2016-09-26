package samples;

import static java.lang.System.*;
/**
 * Using a static variable and a static method
 *
 * To use this;
 *
 * Singleton s = Singleton.getInstance();
 * s.sayHello("Fia");
 *
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void sayHello(String name){
        out.println("Hello " + name);
    }
}
