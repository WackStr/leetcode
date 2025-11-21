package com.wackstr.leetcode;

/*
2025-11-21
 */
public class UniqueThreePalindrome_1930 {

    public static final int N = 'z' - 'a' + 1;

    public int countPalindromicSubsequence(String s){
        int[] count = new int[N];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int[][] palindromes = new int[N][N];
        int[] currCount = new int[N];
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';
            currCount[k]++;
            for(int j = 0; j < N; j++) {
                if (palindromes[k][j] == 0) {
                    int left = currCount[j] - (k == j ? 1 : 0);
                    int right = count[j] - currCount[j];
                    if(palindromes[k][j] == 0)
                        palindromes[k][j] = (left > 0 && right > 0) ? 1 : 0;
                }
            }
        }
        int cnt = 0;
        for (int[] palindrome : palindromes)
            for (int i : palindrome)
                cnt += i;
        return cnt;
    }

    public static void main(String[] args) {
        String s = "bbcbaba";
        UniqueThreePalindrome_1930 sol = new UniqueThreePalindrome_1930();
        System.out.println(sol.countPalindromicSubsequence(s));

    }
}
