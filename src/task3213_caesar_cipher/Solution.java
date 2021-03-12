package task3213_caesar_cipher;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/*
Caesar cipher

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  // Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) {
        StringWriter stringWriter = new StringWriter();
        try {
            // read our String character by character
            int value;
            while ((value = reader.read()) != -1) {
                // change every char by adding the key to it's int value
                // and add result to our stringWriter
                stringWriter.write((char) (value + key));
            }
            // requirement 3 - under no circumstances should null be returned:
        } catch (Exception e){
            return "";
        }
        return stringWriter.toString();
    }
}
