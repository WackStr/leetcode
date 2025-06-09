package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.Pair;

/*
2025-06-09
 */
public class KthLexicographicalOrder_440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            // If the steps are less than or equal to k, we skip this prefix's subtree
            if (step <= k) {
                // Move to the next prefix and decrease k by the number of steps we skip
                curr++;
                k -= step;
            } else {
                // Move to the next level of the tree and decrement k by 1
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    // To count how many numbers exist between prefix1 and prefix2
    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        KthLexicographicalOrder_440 sol = new KthLexicographicalOrder_440();
        int[] order = {1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 3, 4, 5, 6, 7, 8 ,9};
        for(int i = 0; i < order.length; i++){
            if(sol.findKthNumber(order.length, i+1) != order[i])
                System.out.println("problem found on k = " + (i + 1));
        }
        int n = 25;
        int k = 19;
        System.out.println(sol.findKthNumber(n, k));
    }
}
