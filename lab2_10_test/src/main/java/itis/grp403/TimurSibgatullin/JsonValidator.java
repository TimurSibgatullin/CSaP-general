package itis.grp403.TimurSibgatullin;

import java.io.*;
import java.util.Stack;

public class JsonValidator {

    public static int validateJson(String fileName) throws IOException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new NullPointerException("что? где?");
        }

        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("чё ты мне подсунул?");
        }

        try (Reader reader = new FileReader(file)) {
            Stack<Character> stack = new Stack<>();
            int position = 1;
            int ch;

            while ((ch = reader.read()) != -1) {
                char c = (char) ch;

                if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) &&
                        "{}[]".indexOf(c) == -1) {
                    throw new IllegalArgumentException("не вкусно");
                }

                if (c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == '}' || c == ']') {
                    if (stack.isEmpty()) {
                        return position;
                    }
                    char open = stack.pop();
                    if ((c == '}' && open != '{') || (c == ']' && open != '[')) {
                        return position;
                    }
                }

                position++;
            }

            if (!stack.isEmpty()) {
                return position;
            }

            return 0;
        }
    }
}