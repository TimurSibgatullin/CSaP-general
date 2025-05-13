package itis.grp403.TimurSibgatullin.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Общение в рамках договоренности о формате сообщейний (протокол)
 * |длина сообщения (4 байта)|сообщение заявленной длины|
 */

public class ClientMessenger {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 50000);
            // Поток для чтения данных от сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Поток для передачи данных серверу
            PrintWriter writer = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                // Отправляем сообщение на сервер

                Scanner scanner = new Scanner(System.in);

                String message = scanner.nextLine();

                // измеряем кол-во байт в сообщении
                int size = message.getBytes().length;
                writer.write(message + "\n");
                writer.flush();
                if(message.equals("exit")) {
                    break;
                }
                // Читаем послание от сервера

                message = reader.readLine();
                System.out.println(message);

                if(message.equals("exit")) {
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}