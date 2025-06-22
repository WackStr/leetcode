package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-22
 */
public class DecomposeString_2138 {
    public String[] divideString(String s, int k, char fill){
        String[] res = new String[(s.length() + (k - 1))/k];
        int i = 0;
        int j;
        int index = 0;
        StringBuilder curr;
        while(i < s.length() - k){
            curr = new StringBuilder();
            j = i;
            while(j < i + k) curr.append(s.charAt(j++));
            res[index++] = curr.toString();
            i += k;
        }
        if(i < s.length()){
            curr = new StringBuilder();
            j = i;
            while(j < Math.min(s.length(), i+k)) curr.append(s.charAt( j++));
            curr.append(String.valueOf(fill).repeat(Math.max(0, k - curr.length())));
            res[index] = curr.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ctoyjrwtngqwt";
        int k = 8;
        char fill = 'n';
        DecomposeString_2138 sol = new DecomposeString_2138();
        System.out.println(Arrays.toString(sol.divideString(s, k, fill)));
    }
}
