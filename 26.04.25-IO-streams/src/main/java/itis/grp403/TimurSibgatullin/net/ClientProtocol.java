package itis.grp403.TimurSibgatullin.net;

import java.io.*;
import java.net.Socket;

public class ClientProtocol {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 50000);

            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            String message = "hello from client";
            int size = "hello from client".getBytes().length;
            os.write(size);
            os.write(message.getBytes());
            os.flush();

            size = is.read();
            byte[] buffer= new byte[size];
            is.read(buffer);
            System.out.println(new String(buffer));


            is.close();
            os.close();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
