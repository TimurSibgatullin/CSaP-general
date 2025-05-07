package itis.grp403.TimurSibgatullin.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            Socket clientSocket = serverSocket.accept();
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            byte[] buffer = new byte[100];
            int r = is.read(buffer);
            System.out.println(new String(buffer, 0, r));

            os.write("hello from server".getBytes());
            os.flush();

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
