package assignments.uber.webserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handler for Http requests
 *
 * Should read HTML files (CSS , JavaScript) and sent back to client
 * So need some file handling (not present here)
 */

public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
        OutputStream os = t.getResponseBody();
        if (t.getRequestMethod().equals("GET")) {
            // Dummy response, should send HTML
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
        } else {
            String method = t.getRequestMethod();
            Logger.getAnonymousLogger().log(Level.INFO, "Incoming " + method);
            t.sendResponseHeaders(200, method.length());
            os.write(method.getBytes());
        }
        os.close();
    }
}


