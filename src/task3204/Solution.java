package task3204;

import java.io.ByteArrayOutputStream;

/*
Password generator
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(8);
        byte[] passwordArray = new byte[8];
        boolean containsNumeral = false;
        boolean containsLowercase = false;
        boolean containsUppercase = false;

        while (!(containsNumeral && containsLowercase && containsUppercase)) {
            containsNumeral = false;
            containsLowercase = false;
            containsUppercase = false;
            passwordArray = fillArray();

            for (byte b : passwordArray) {
                if (b >= 48 && b <= 57)
                    containsNumeral = true;
                else if (b >= 97 && b <= 122)
                    containsLowercase = true;
                else if (b >= 65 && b <= 90)
                    containsUppercase = true;
            }
        }
        baos.write(passwordArray, 0, 8);
        return baos;
    }
    private static byte[] fillArray() {
        byte[] array = new byte[8];
        for (int i = 0; i < 8; i++) {
            array[i] = (byte) getRandomChar();
        }
        return array;
    }
    private static int getRandomChar() {
        int randomMethodNumber = getRandom(1, 3);
        if (randomMethodNumber == 1)
            return getRandomNumeral();
        else if (randomMethodNumber == 2)
            return getRandomLowercase();
        else return getRandomUppercase();
    }
    private static int getRandomNumeral() {
        return getRandom(48, 57);
    }
    private static int getRandomLowercase() {
        return getRandom(97, 122);
    }
    private static int getRandomUppercase() {
        return getRandom(65, 90);
    }
    private static int getRandom(int min, int max) {
        int range = max - min + 1;
        int random = 0;
        for (int i = 0; i < max; i++) {
            random = (int) (Math.random() * range) + min;
        }
        return random;
    }

}

