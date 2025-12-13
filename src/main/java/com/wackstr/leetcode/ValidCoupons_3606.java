package com.wackstr.leetcode;

import java.util.*;

/*
2025-12-13 3606
 */
public class ValidCoupons_3606 {
    private static final Set<String> BUSINESS_LINES = Set.of(
            "electronics", "grocery", "pharmacy", "restaurant"
    );

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, List<String>> lists = new HashMap<>();
        BUSINESS_LINES.forEach(t -> lists.put(t, new ArrayList<>()));

        int n = code.length;

        for (int i = 0; i < n; i++) {
            if (isActive[i] &&
                    BUSINESS_LINES.contains(businessLine[i]) &&
                    isValidCode(code[i])) {
                lists.get(businessLine[i]).add(code[i]);
            }
        }
        lists.forEach((a,b) -> b.sort(Comparator.naturalOrder()));
        return lists.keySet().stream().sorted().flatMap(t -> lists.get(t).stream()).toList();
    }

    private static boolean isValidCode(String code) {
        if(code == null || code.isEmpty()) return false;
        boolean validCode = true;
        for (int j = 0; j < code.length(); j++) {
            char c = code.charAt(j);
            if (c != '_' && !Character.isLetterOrDigit(c)) {
                validCode = false;
                break;
            }
        }
        return validCode;
    }
}
