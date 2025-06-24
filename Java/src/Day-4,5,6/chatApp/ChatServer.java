import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("✅ Server started. Waiting for client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("📞 Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Thread to read server input and send to client
        new Thread(() -> {
            try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
                String serverMsg;
                while ((serverMsg = console.readLine()) != null) {
                    out.println("Server: " + serverMsg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Main thread reads client messages
        String clientMsg;
        while ((clientMsg = in.readLine()) != null) {
            System.out.println(clientMsg);
        }

        clientSocket.close();
        serverSocket.close();
    }
}
