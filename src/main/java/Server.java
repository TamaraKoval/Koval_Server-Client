import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        String startPointer = "???";

        try (ServerSocket serverSocket = new ServerSocket(8086)) {
            System.out.println("Сервер работает!=) Игра началась");

            while(true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Установлено новое соединение");

                    out.println(startPointer);
                    String message = in.readLine();
                    if (startPointer.equals("???")) {
                        out.println("ОК");
                        startPointer = message;
                    } else {
                        if (startPointer.charAt(startPointer.length()-1) == Character.toLowerCase(message.charAt(0))) {
                            out.println("ОК");
                            startPointer = message;
                        } else {
                            out.println("NOT ОК, You lose");
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

