package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2026-04-22 2452
 */
public class TwoEditWords_2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary){
        List<String> res = new ArrayList<>();
        int n = queries[0].length();
        for (String query : queries) {
            for (String s : dictionary) {
                int cnt = 0;
                for(int i = 0; i < n && cnt <= 2; i++){
                    if(query.charAt(i) != s.charAt(i)) cnt++;
                }
                if(cnt <= 2) {
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] queries = {"tsl","sri","yyy","rbc","dda","qus","hyb","ilu","ahd"};
        String[] dictionary = {"uyj","bug","dba","xbe","blu","wuo","tsf","tga"};
        TwoEditWords_2452 sol = new TwoEditWords_2452();
        System.out.println(sol.twoEditWords(queries, dictionary));
    }
}
