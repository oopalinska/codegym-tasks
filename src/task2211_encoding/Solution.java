package task2211_encoding;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
Changing the encoding

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        OutputStream outputStream = new FileOutputStream(args[1]);

        byte[] buffer = new byte[1000];
        while (inputStream.available() > 0) {
            inputStream.read(buffer);
            String s = new String(buffer, "Windows-1251");
            buffer = s.getBytes(StandardCharsets.UTF_8);
            outputStream.write(buffer);
        }

        /* Other solution (shorter):

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"))) {

            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
            }
        }
         */
    }
}
