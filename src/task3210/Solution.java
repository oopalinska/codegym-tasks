package task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Using RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            //first save needed text into byte array
            //then convert it into String, so you will be able to compare it
            byte[] byteArray = new byte[text.length()];
            raf.seek(number);
            raf.read(byteArray, 0, byteArray.length);
            String textToCompare = new String(byteArray);
            //move the cursor to the end of file
            // and write "true" or "false" depending on the condition
            raf.seek(raf.length());
            if (text.equals(textToCompare)) {
                raf.write("true".getBytes());
            } else raf.write("false".getBytes());
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }
}
