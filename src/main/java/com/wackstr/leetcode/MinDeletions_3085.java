package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
2025-06-21
 */
public class MinDeletions_3085 {

    public int minimumDeletions(String word, int k){
        int[] cnts = new int[26];
        for(int i = 0; i < word.length(); i++){
            cnts[word.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < cnts.length; i++){
            if(cnts[i] != 0){
                int curr = 0;
                for(int j = 0; j < cnts.length; j++){
                    if(cnts[j] != 0){
                        if(cnts[j] < cnts[i]) curr += cnts[j];
                        else if(cnts[j] > cnts[i] + k) curr += cnts[j] - cnts[i] - k;
                    }
                }
                res = Math.min(res, curr);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String word = "aaabaaa";
        int k = 2;
        MinDeletions_3085 sol = new MinDeletions_3085();
        System.out.println(sol.minimumDeletions(word, k));
    }
}
