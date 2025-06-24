import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        //This creates a server socket listening on port 8080.
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is waiting for client...");

        //When a client connects, it returns a Socket object (clientSocket) for communication.
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        //Reads data sent by the client through the socket.
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //Used to send messages back to the client.
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //Used to send messages back to the client.

        // Receives a message (a line of text) from the client.
        String message = in.readLine();
        System.out.println("Received from client: " + message);

        out.println("Hello from server!");

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
