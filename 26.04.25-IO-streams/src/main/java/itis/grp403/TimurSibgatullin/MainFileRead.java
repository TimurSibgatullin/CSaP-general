package itis.grp403.TimurSibgatullin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainFileRead {
    public static void main(String[] args) {
        long test1 = 0;
        try (InputStream fis = new FileInputStream("bookings.json")) {
            int r;
            long start = System.nanoTime();
            while ((r = fis.read()) > -1) {
                //System.out.print((char) r);
            }
            long end = System.nanoTime();
            test1 = end - start;
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream fis = new FileInputStream("bookings.json")) {
            int r;
            byte[] buffer = new byte[1024];
            long start = System.nanoTime();
            while ((r = fis.read(buffer)) > -1) {
                System.out.print(new String(buffer, 0, r));
            }
            long end = System.nanoTime();
            long test2 = end - start;
            System.out.println(end - start);
            System.out.println(test1 / test2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
