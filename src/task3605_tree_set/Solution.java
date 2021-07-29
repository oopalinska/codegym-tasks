package task3605_tree_set;

/*
Using TreeSet

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> characters = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String contents;
        while((contents = reader.readLine()) != null) {
            for (char character : contents.toLowerCase().toCharArray()) {
                if (character >= 97 && character <= 122) {
                    characters.add(character);
                }
            }
        }
        reader.close();

        int count = 0;
        for (Character c : characters) {
            System.out.print(c);
            count++;
            if (count == 5) {
                break;
            }
        }
    }
}

