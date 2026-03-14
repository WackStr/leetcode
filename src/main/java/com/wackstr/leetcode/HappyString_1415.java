package com.wackstr.leetcode;

/*
2026-03-14 1415
 */
public class HappyString_1415 {
    private static final char[][] chars = {{'b','c'}, {'a','c'}, {'a','b'}};
    public String getHappyString(int n, int k){
        if(k > (3 * (1 << (n-1)))) return "";

        int[] levels = new int[n - 1];

        for(int i = n - 2; i >= 0; i--){
            levels[i] = (k + 1) % 2;
            k = (k + 1)/2;
        }

        int i = 0;
        char[] res = new char[n];
        char curr = (char) ('a' + (k - 1));
        res[i] = curr;
        i++;
        for (int level : levels) {
            curr = chars[(curr-'a')][level];
            res[i] = curr;
            i++;
        }

        return new String(res);
    }

    public static void main(String[] args) {
        int n = 1, k = 3;
        HappyString_1415 sol = new HappyString_1415();
        System.out.println(sol.getHappyString(n, k));
    }
}
