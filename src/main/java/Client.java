import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cityFromServer;
        System.out.println("Клиент к игре готов!");

        try (Socket socket = new Socket("localhost", 8086);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                cityFromServer = in.readLine();
                if (cityFromServer.equals("???")) {
                    System.out.println("Вы начинаете игру, можно ввести любой город:");
                } else {
                    System.out.println("Город: " + cityFromServer);
                    System.out.println("Введите город, начинающийся на последнюю букву:");
                }

            String input = scanner.nextLine();
            out.println(input);
            System.out.println("Сервер ответил: " + in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
