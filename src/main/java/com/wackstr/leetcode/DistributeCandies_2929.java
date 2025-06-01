package com.wackstr.leetcode;

/*
2025-06-01
 */
public class DistributeCandies_2929 {
    public long distributeCandies(int n, int limit){
        long cnt = 0;
        for(int i = 0; i <= Math.min(limit, n); i++){
            int target = n - i;
            cnt += getCount(target, limit);
        }
        return cnt;
    }

    private long getCount(int target, int limit) {
        if(target <= limit) return target + 1L;
        if(target / 2 <= limit) return 2L * limit - target + 1;
        return 0;
    }

    private static long bruteForce(int n, int limit) {
        long cnt = 0;
        for(int i = 0; i <= limit; i++){
            for(int j = 0; j <= limit; j++){
                if(n - (i + j) <= limit && n - (i + j) >= 0) {
                    System.out.printf("(%d, %d, %d)%n", i, j, (n - i - j));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 3;
        int limit = 3;
        DistributeCandies_2929 sol = new DistributeCandies_2929();
        System.out.println(sol.distributeCandies(n, limit));
    }
}
