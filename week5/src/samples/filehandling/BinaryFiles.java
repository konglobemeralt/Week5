/*
//package samples.filehandling;
//
//import java.io.*;
//
//import static java.lang.System.*;
///*
//   Using binary files to store objects
// */
//public class BinaryFiles {
//
//    public static void main(String[] args) {
//        new BinaryFiles().program();
//    }
//
//    void program() {
//        // Object to store
//        MyClass o = new MyClass("pelle");
//        o.setName("pelle");
//        try {
//            // Write object to file
//            FileService.writeObject("src/samples/filehandling/", "pelle.ser", o);
//            // Read it back
//            MyClass o1 = FileService.readObject("src/samples/filehandling/", "pelle.ser");
//            out.println( o == o1);
//            out.println( o.getName().equals(o1.getName()));
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//
//}
///*