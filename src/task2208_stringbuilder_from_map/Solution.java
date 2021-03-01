package task2208_stringbuilder_from_map;

import java.util.HashMap;
import java.util.Map;

/*
Build a WHERE query

Another loop explanation in comments.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("name", "Johnson");
        testMap.put("country", "United States");
        testMap.put("city", "Los Angeles");
        testMap.put("age", null);
        System.out.println(getQuery(testMap));

    }
    public static String getQuery(Map<String, String> params) {
        // How it works for our testMap:
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            String value = params.get(key);
            // At the first round we skip two ifs and go straight to the line 32.
            // * if the value is null, we go back to the line 24.
            if (value == null) continue;
            if (sb.toString().length() != 0) {
                sb.append(" and ");
            }
            sb.append(key).append(" = '").append(value).append("'");
            // Everytime the value is not null, we will get next pair and before appending with its data, append "and".
            // If there is no next pair, " and " will not be added (we will finish here).
        }
        return sb.toString();
    }
}
