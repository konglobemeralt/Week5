package assignments.uber.webserver;
/*

   To compile
   javac Server.java

   To run
   java Server

   Try a web browser
   http://localhost:8000/test

    and try this (and more...)

    $ curl -X POST http://localhost:8080/test -v
    $ curl -X GET http://localhost:8000/test -v

*/

import java.net.InetSocketAddress;
import java.util.logging.Logger;
import java.util.logging.Level;

import com.sun.net.httpserver.HttpServer;

public class Server {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
        Logger.getAnonymousLogger().log(Level.INFO, "Starting server at 8000");
        server.start();
    }

}
