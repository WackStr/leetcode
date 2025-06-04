package com.wackstr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
2025-06-04
 */
public class WordSplit_3403 {
    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String last = lastSubstring(word);
        int n = word.length(), m = last.length();
        return last.substring(0, Math.min(m, n - numFriends + 1));
    }

    private static String manualContruction(String word, int numFriends) {
        if(numFriends == 1) return word;
        // O(1)
        int max = -1;
        Queue<Integer> indices = new LinkedList<>();
        // 0(N)
        for(int i = 0; i < word.length(); i++){
            int curr = word.charAt(i) - 'a';
            if(curr > max){
                max = curr;
                indices = new LinkedList<>();
                indices.add(i);
            }else if(curr == max){
                indices.offer(i);
            }
        }
        int maxLength = word.length() - numFriends + 1;
        if(numFriends == word.length() || indices.size() == 1){
            int start = indices.peek();
            int end = Math.min(start + maxLength, word.length());
            return word.substring(start, end);
        }else {
            StringBuilder res = new StringBuilder();
            res.append((char) ('a' + max));
            int offset = 1;
            while(!indices.isEmpty() && offset < maxLength) {
                Queue<Integer> nextQueue = new LinkedList<>();
                max = -1;
                boolean add = false;
                for (int i : indices) {
                    if (i + offset < word.length()) {
                        char c = word.charAt(i + offset);
                        int curr = c - 'a';
                        if (curr > max) {
                            max = curr;
                            nextQueue = new LinkedList<>();
                            nextQueue.offer(i);
                            add = true;
                        } else if (curr == max){
                            nextQueue.offer(i);
                        }
                    }
                }
                if(add) res.append((char) ('a' + max));
                offset++;
                indices = nextQueue;
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        String word = "hnoog";
        int numFriends = 3;
        WordSplit_3403 sol = new WordSplit_3403();
        System.out.println(sol.answerString(word, numFriends));
    }
}
