package itis.grp403.TimurSibgatullin.testFiles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//3. Текст перевести в ByteArrayInputStream, скопировать побайтно в ByteArrayOutputStram, записать в файл. Написать тест
//процедуры копирования.

public class Main3 {
    public static ByteArrayOutputStream copy(ByteArrayInputStream bais) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int r;
        while ((r = bais.read()) != -1) {
            baos.write(r);
        }
        return baos;
    }

    public static void main(String[] args) {
        String text = "Hello, World";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = copy(byteArrayInputStream);
        try (FileOutputStream fos = new FileOutputStream("text2.txt")) {
            fos.write(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}