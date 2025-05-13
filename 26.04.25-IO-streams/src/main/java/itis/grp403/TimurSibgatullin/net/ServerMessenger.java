package itis.grp403.TimurSibgatullin.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 * Общение в рамках договоренности о формате сообщейний (протокол)
 * |длина сообщения (4 байта)|сообщение заявленной длины|
 */
public class ServerMessenger {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            // Ожидаем подключения клиента
            Socket clientSocket = serverSocket.accept();
            // Дождались клиента
            // Поток для чтения данных от клиента
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Поток для передачи данных клиенту
            PrintWriter writer = new PrintWriter( new OutputStreamWriter(clientSocket.getOutputStream()));
            while (true) {


                // Читаем пакет от клиента
                String message = reader.readLine();
                System.out.println(message);

                if(message.equals("exit")) {
                    break;
                }


                Scanner scanner = new Scanner(System.in);

                message = scanner.nextLine();
                // измеряем кол-во байт в сообщении
                writer.write(message + "\n");
                writer.flush();
                if(message.equals("exit")) {
                    break;
                }
            }
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}