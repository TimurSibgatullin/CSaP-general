package itis.grp403.TimurSibgatullin.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProtocol {
    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(50000);
                Socket clientSocket = serverSocket.accept();
                DataInputStream is = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
                int size = is.read();
                byte[] buffer = new byte[size];
                is.read(buffer);
                System.out.println(new String(buffer));

                Scanner sc = new Scanner(System.in);

                String message = sc.nextLine();
                size = message.getBytes().length;
                os.write(size);
                os.write(message.getBytes());

                os.flush();

                os.write("hello from server".getBytes());
                os.flush();
                if (message.equals("exit")) {
                    break;
                }
            }
//            clientSocket.close();
//            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
