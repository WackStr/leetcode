package com.wackstr.leetcode;

/*
2026-08-26 2904
 */
public class BeautifulString_2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        char[] arr = s.toCharArray();
        int ones = 0;
        StringBuilder builder = new StringBuilder();
        String res = "";
        for (int right = 0; right < arr.length; right++){
            char c = arr[right];
            builder.append(c);
            if (c == '1') ones++;
            while (left <= right && (ones > k || arr[left] == '0')) {
                if (arr[left] == '1') {
                    ones--;
                }
                left++;
                builder.deleteCharAt(0);
            }
            if (ones == k) {
                if(res.isEmpty()) {
                    res = builder.toString();
                }else{
                    if(builder.length() < res.length() || (builder.length() == res.length() && builder.toString().compareTo(res) < 0)) {
                        res = builder.toString();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "000";
        int k = 3;
        BeautifulString_2904 sol = new BeautifulString_2904();
        System.out.println(sol.shortestBeautifulSubstring(s,k));

    }
}
