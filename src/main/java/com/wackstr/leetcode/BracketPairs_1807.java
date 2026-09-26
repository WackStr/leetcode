package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2026-09-26 1807
 */
public class BracketPairs_1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder keyBuilder = new StringBuilder();
        boolean insideBrackets = false;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                insideBrackets = true;
                keyBuilder = new StringBuilder();
            } else if (c == ')') {
                insideBrackets = false;
                String key = keyBuilder.toString();
                result.append(map.getOrDefault(key, "?"));
            } else if (insideBrackets) {
                keyBuilder.append(c);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
