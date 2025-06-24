import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        //  Initiates a connection to the server at 8080
        Socket socket = new Socket("localhost", 8080);

        // To receive response messages from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Used to send a message to the server.
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hi Server, I'm Client!");
        // Waits and reads the server’s reply
        String response = in.readLine();
        System.out.println("Received from server: " + response);

        in.close();
        out.close();
        socket.close();
    }
}
