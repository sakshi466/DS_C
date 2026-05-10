import java.net.*;
import java.io.*;

public class server {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(3300);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            Socket socket = server.accept();
            System.out.println("Client accepted");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter
                (socket.getOutputStream(),true);

            

            String message = in.readLine();
            System.out.println("Message from client: " + message);

            out.println("Hello client");

            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}