package com.wackstr.leetcode;

/*
2025-05-13
 */
public class StringTransformation_3335 {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t){
        int[] curr = new int[26];
        for(int i = 0; i < s.length(); i++){
            curr[s.charAt(i) - 'a']++;
        }
        int[] next = new int[26];
        for(int j = t - 1; j >= 0; j--){
            int carry = curr[25];
            System.arraycopy(curr, 0, next, 1, 25);
            next[0] = carry;
            next[1] = (next[1] + carry) % MOD;
            curr = next;
        }
        int res = 0;
        for(int i = 0; i < 26; i++) {
            res = (res + curr[i]) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcyy";
        int t = 2;
        StringTransformation_3335 sol = new StringTransformation_3335();
        System.out.println(sol.lengthAfterTransformations(s, t));
    }
}
