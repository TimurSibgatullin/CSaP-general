package itis.grp403.TimurSibgatullin;
import java.io.*;


public class FileMerge {
    public String mergeFiles() throws IOException {
        String outputName = "merged.bin";
        try (OutputStream os = new FileOutputStream(outputName);
             InputStream is1 = new FileInputStream("pushkin.txt");
             InputStream is2 = new FileInputStream("Вопросы-по-геометрии-2025.docx")) {

            copyStream(is1, os);
            copyStream(is2, os);
        }
        return outputName;
    }

    private void copyStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
    }
}