package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2025-05-14
 */
public class StringTransformation_3337 {

    private static final int MOD = 1_000_000_007;
    private static final int CHARS = 26;

    // Matrix multiplication
    private long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int k = 0; k < 26; ++k) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < 26; ++j) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    // Matrix exponentiation
    private long[][] matrixPow(long[][] mat, int power) {
        long[][] result = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            result[i][i] = 1;
        }
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiply(result, mat);
            }
            mat = multiply(mat, mat);
            power /= 2;
        }
        return result;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // Initialize the transition matrix
        long[][] transition = new long[26][26];
        for (int c = 0; c < 26; ++c) {
            int num = nums.get(c);
            for (int j = 1; j <= num; ++j) {
                int nextChar = (c + j) % 26;
                transition[c][nextChar]++;
            }
        }

        // Raise the transition matrix to the t-th power
        long[][] matPow = matrixPow(transition, t);

        // Initialize the initial count vector
        long[] cnt = new long[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Multiply the count vector by the matrix^t
        long[] newCnt = new long[26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                newCnt[j] = (newCnt[j] + cnt[i] * matPow[i][j]) % MOD;
            }
        }

        // Sum all the counts
        long total = 0;
        for (long x : newCnt) {
            total = (total + x) % MOD;
        }
        return (int)total;
    }

    private int lengthAfterArray_matrixSimulation(String s, int t, List<Integer> nums) {
        int[] curr = getCharCounts(s);
        while(t > 0){
            int[] next = new int[CHARS];
            for(int i = 0; i < curr.length; i++){
                int chars = nums.get(i);
                postCharacters(curr, next, i, chars);
            }
            curr = next;
            t--;
        }
        return getModdedSum(curr);
    }

    private static int getModdedSum(int[] curr) {
        int res = 0;
        for (int num : curr) res = (res + num) % MOD;
        return res;
    }

    private static void postCharacters(
            int[] curr, int[] next, int i, int chars) {
        for(int j = 0; j < chars; j++){
            int index = (i+j+1) % CHARS;
            next[index] = (next[index] + curr[i]) % MOD;
        }
    }

    private int[] getCharCounts(String s) {
        int[] curr = new int[CHARS];
        for(int i = 0; i < s.length(); i++){
            curr[getIndex(s.charAt(i))]++;
        }
        return curr;
    }

    private int getIndex(char c) {
        return c-'a';
    }

    public static void main(String[] args) {
        String s = "azbk";
        int t = 1;
        int[] numArray = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        List<Integer> nums =
                new ArrayList<>(Arrays.stream(numArray).boxed().toList());
        StringTransformation_3337 sol = new StringTransformation_3337();
        System.out.println(sol.lengthAfterTransformations(s, t, nums));
    }
}
