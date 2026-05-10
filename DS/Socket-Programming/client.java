import java.net.*;
import java.io.*;

public class client {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("localhost", 3300);
            System.out.println("Connected");

            PrintWriter out = new PrintWriter(
                socket.getOutputStream(),true);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            
            
            out.println("Hello server");

            String message = input.readLine();
            System.out.println("Message from server: " + message);


            socket.close();
           

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}