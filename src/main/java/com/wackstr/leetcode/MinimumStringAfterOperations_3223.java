package com.wackstr.leetcode;

/*
2025-01-13
 */
public class MinimumStringAfterOperations_3223 {
    public int minimumLength(String s){
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            cnt[index] += 1;
        }
        int sum = 0;
        for (int val : cnt) {
            sum += val < 3 ? val : ((val & 1) == 1) ? 1 : 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "abaacbcbb";
        MinimumStringAfterOperations_3223 sol =
                new MinimumStringAfterOperations_3223();
        System.out.println(sol.minimumLength(s));
    }
}
