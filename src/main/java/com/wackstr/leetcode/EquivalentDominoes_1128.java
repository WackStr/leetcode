package com.wackstr.leetcode;

/*
2025-05-04
 */
public class EquivalentDominoes_1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        for(int[] domino : dominoes){
            int index = domino[0] < domino[1] ?
                    domino[1] * 10 + domino[0] :
                    domino[0] * 10 + domino[1];
            count[index]++;
        }
        int res = 0;
        for(int n : count){
            res += n * (n-1)/2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] dominoes = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {1, 1}};
        EquivalentDominoes_1128 sol = new EquivalentDominoes_1128();
        System.out.println(sol.numEquivDominoPairs(dominoes));
    }
}
