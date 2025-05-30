package itis.grp403.TimurSibgatullin.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 50000);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            os.write("hello from client".getBytes());
            os.flush();
            byte[] buffer = new byte[100];
            int r = is.read(buffer);
            System.out.println(new String(buffer, 0, r));

            os.write("hello from server".getBytes());
            os.flush();

            is.close();
            os.close();
        } catch (
        IOException e) {
            throw new RuntimeException(e);
        }
    }
}
