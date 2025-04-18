package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2025-04-18
 */
public class CountAndSay_38 {


    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = buildNext(res);
        }
        return res;
    }

    private String buildNext(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count).append(s.charAt(s.length() - 1));
        return result.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        CountAndSay_38 sol = new CountAndSay_38();
        System.out.println(sol.countAndSay(n));
    }
}
