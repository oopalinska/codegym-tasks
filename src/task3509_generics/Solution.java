package task3509_generics;

/*
Collections & Generics

*/

import java.util.*;

public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        HashMap<K,V> result = new HashMap<>();
        for (K key : keys) {
            result.put(key, values.get(keys.indexOf(key)));
        }
        return result;
    }
}
