package itis.grp403.TimurSibgatullin.net;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;


public class ClientProtocol {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 50000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()));

            String message = "hello from client";
            writer.write(message + "\n");
            writer.flush();

            System.out.println(reader.readLine());
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
