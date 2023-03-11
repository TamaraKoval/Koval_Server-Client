import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        System.out.println("Клиент готов коннектиться!");

        try (Socket socket = new Socket("localhost", 8086);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                out.println("Однако, здравствуйте");
                String message = in.readLine();
                System.out.println("Сервер прислал сообщение:\n" + message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
