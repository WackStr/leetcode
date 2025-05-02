package com.wackstr.leetcode;

/*
2025-05-02
 */
public class PushDominoes_838 {
    public String pushDominoes(String dominoes){
        int n = dominoes.length();
        int[] left = new int[n], right = new int[n];

        char[] chars = dominoes.toCharArray();

        right[0] = chars[0] == 'R' ?  0 : -1;
        for(int i = 1; i < n; i++) {
            char c = chars[i];
            right[i] = switch (c) {
                case 'L' -> -1;
                case 'R' -> 0;
                default -> (right[i - 1] == -1 ?  -1 : right[i-1] + 1);
            };
        }
        left[n-1] = chars[n-1] == 'L' ? 0 : -1;
        for(int i = n - 2; i >= 0; i--){
            char c = chars[i];
            left[i] = switch(c) {
                case 'R' -> -1;
                case 'L' -> 0;
                default -> (left[i + 1] == -1 ?  -1 : left[i + 1] + 1);
            };
        }

        for(int i = 0; i < n; i++){
            char c = chars[i];

            if(c != '.') chars[i] = (c);
            else{
                int cmp = Integer.compare(right[i], left[i]);
                if(cmp < 0) chars[i] = right[i] == -1 ? 'L' : 'R';
                else if (cmp > 0) chars[i] = left[i] == -1 ? 'R' : 'L';
                else chars[i] = '.';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        PushDominoes_838 sol = new PushDominoes_838();
        System.out.println(sol.pushDominoes(dominoes));
    }
}
