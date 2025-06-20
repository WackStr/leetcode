package com.wackstr.leetcode;

/*
2025-06-20
 */
public class MaxManhattan_3443 {

    public int maxDistance(String s, int k) {
        int N = 0, S = 0, W = 0, E = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N': N++; break;
                case 'S': S++; break;
                case 'W': W++; break;
                case 'E': E++; break;
                default: break;
            }
            max = Math.max(max, getMax(N, S, W, E, k));
        }
        return max;
    }

    public int getMax(int N, int S, int W, int E, int k){
        int correction = Math.min(Math.min(N, S), k);
        if (N < S) {
            N -= correction;
            S += correction;
        } else {
            N += correction;
            S -= correction;
        }
        k -= correction;
        correction = Math.min(Math.min(E, W), k);
        if (E < W) {
            E -= correction;
            W += correction;
        } else {
            E += correction;
            W -= correction;
        }
        return Math.abs(N - S) + Math.abs(E - W);
    }

    public static void main(String[] args) {
        String s = "NSES";
        int k = 1;
        MaxManhattan_3443 sol = new MaxManhattan_3443();
        System.out.println(sol.maxDistance(s, k));
    }
}
