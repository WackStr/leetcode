package com.wackstr.leetcode;

/*
2025-03-08
 */
public class MinimumRecolors_2379 {
    public int minimumRecolors(String blocks, int k){
        int left = 0;
        int right = 0;
        int maximumBlackBlocks = 0;
        int currWindowBlackBlocks = 0;
        while(right < blocks.length()){
            if(isBlack(blocks, right)){
                currWindowBlackBlocks++;
            }
            if(right - left == k - 1) {
                maximumBlackBlocks =
                        Math.max(maximumBlackBlocks, currWindowBlackBlocks);
                if(isBlack(blocks, left)){
                    currWindowBlackBlocks--;
                }
                left++;
            }
            right++;
        }
        return Math.max(k - maximumBlackBlocks, 0);
    }

    private boolean isBlack(String blocks, int index) {
        return blocks.charAt(index) == 'B';
    }

    public static void main(String[] args) {
        String blocks = "WWWW";
        int k = 2;

        MinimumRecolors_2379 sol = new MinimumRecolors_2379();
        System.out.println(sol.minimumRecolors(blocks, k));
    }
}
