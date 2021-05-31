package task2207_inverted_words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Inverted words

I precisely explained the logic of my loop in the comments.
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        List<String> words = new ArrayList<>();
        // Read the name of a file from console, we will work on this file.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        // Fill the previously created words list with all the words included in the file.
        while (fileReader.ready()) {
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();

        // We need to work with two pointers: one for the first word and one for the second word to compare.
        for (int i = 0; i < words.size(); i++) {
            // I don't add the "j++" at the end, because I want it to depend on some conditions.
            // It will be easier to include it in my if-else statement below.
            for (int j = 0; j < words.size(); ) {
                // If is executed only when j is equal to reversed i, but not at the same position
                // (then it is the same word - palindrome - and we would make a big mistake).
                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && i != j) {
                    // We found a pair! We save it in the new Pair object:
                    Pair pair = new Pair();
                    pair.first = words.get(j);
                    pair.second = words.get(i);
                    // Add our pair to the result list and move on,
                    // but first delete both words that created it from our words list (they can't be included again).
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    // The i pointer stays the same - now the new word jumped on its place.
                    // The j pointer has to be moved back - we need to start checking from beginning of a list again.
                    j = 0;
                }
                // We get here if the previous j was not equal to reversed i. We move to the next j.
                else j++;
            }
            // We increase i number only if the word under this index doesn't have any "matching" words.
        }



    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (!Objects.equals(first, pair.first)) return false;
            return Objects.equals(second, pair.second);

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}

