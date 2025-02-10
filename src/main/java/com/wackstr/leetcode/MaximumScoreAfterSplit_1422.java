package com.wackstr.leetcode;

/*
2025-01-01
 */
public class MaximumScoreAfterSplit_1422 {
    public int maxScore(String s){
        int totalOnes = getTotalOnes(s);
        int maxScore = 0;
        int currZero = 0;
        int currOne = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') {
                currZero++;
            }else{
                currOne++;
            }
            int currScore = currZero + totalOnes - currOne;
            maxScore = Math.max(maxScore, currScore);
        }
        return maxScore;
    }

    private static int getTotalOnes(String s) {
        int totalOnes = 0;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '1') totalOnes++;
        }
        return totalOnes;
    }

    public static void main(String[] args) {
        String s = "00";
        MaximumScoreAfterSplit_1422 sol = new MaximumScoreAfterSplit_1422();
        System.out.println(sol.maxScore(s));
    }
}
