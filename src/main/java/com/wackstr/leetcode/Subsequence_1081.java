package com.wackstr.leetcode;

/*
2026-07-19 1081
 */
public class Subsequence_1081 {
    public String smallestSubsequence(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

    private String backTrackApproach(String s) {
        int n = s.length();
        boolean[] chars = new boolean[26];
        char[] arr = s.toCharArray();
        int[][] prefix = new int[n][26];
        for (char c : arr)
            chars[c-'a'] = true;
        prefix[n-1][arr[n-1]-'a'] = n-1;
        for (int i = n - 2; i >= 0; i-- ){
            System.arraycopy(prefix[i + 1],
                    0, prefix[i], 0, 26);
            prefix[i][arr[i]-'a'] = i;
        }
        int k = 0;
        for (boolean c : chars)
            if(c) k++;
        char[] res = new char[k];
        // build smallest through backtracking here:
        backtrack(res, 0, prefix, 0, chars, new boolean[26]);
        return new String(res);
    }

    private boolean backtrack(
            char[] res, int resIndex,
            int[][]prefix, int prefixIndex,
            boolean[] chars, boolean[] usedChars) {
        if(resIndex >= res.length) return true;
        if(prefixIndex >= prefix.length) return false;
        for(int i = 0; i < 26; i++){
            if(!chars[i]
                    || usedChars[i]
                    || prefix[prefixIndex][i] < prefixIndex) continue;
            char c = (char)('a' + i);
            res[resIndex] = c;
            usedChars[i] = true;
            if(backtrack(
                    res, resIndex+1,
                    prefix, prefix[prefixIndex][i]+1,
                    chars, usedChars)) return true;
            usedChars[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        Subsequence_1081 sol = new Subsequence_1081();
        System.out.println(sol.smallestSubsequence(s));
    }
}
