import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8086)) {
            System.out.println("Сервер работает!=) Добро пожаловать");

            while(true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Установлено новое соединение\n");
                    String message = in.readLine();
                    System.out.println("Принятое сообщение: " + message);
                    System.out.println("Номер порта, с которого пришло сообщение: " + clientSocket.getPort());


                    out.println("Привет! я тебя спалил хаха! номер твоего порта: " + clientSocket.getPort());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

