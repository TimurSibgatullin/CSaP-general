package itis.grp403.TimurSibgatullin;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class FileMerge {
    public String mergeFiles() throws IOException {
        String outputName = "merged.bin";
        try (OutputStream os = new FileOutputStream(outputName);
             InputStream is1 = new FileInputStream("pushkin.txt");
             InputStream is2 = new FileInputStream("Вопросы-по-геометрии-2025.docx")) {
            is1.transferTo(os);
            is2.transferTo(os);

        }
        return outputName;
    }
}