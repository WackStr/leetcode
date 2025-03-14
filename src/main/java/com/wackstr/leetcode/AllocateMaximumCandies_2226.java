package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-03-14
 */
public class AllocateMaximumCandies_2226{

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int maxCandy = 0;
        for (int candy : candies) {
            sum += candy;
            maxCandy = Math.max(candy, maxCandy);
        }
        if (sum < k) return 0;
        int left = 0;
        int right = maxCandy;
        int mid;
        while(left < right) {
            mid = right == left + 1 ? right : left + (right - left) / 2;
            if (canGiveCandies(candies, k, mid)) {
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean canGiveCandies(int[] candies, long k, int candy){
        long totalBags = 0;
        for(int bag : candies){
            if(bag >= candy){
                totalBags += bag/candy;
            }
            if(totalBags >= k){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] candies = {1,2,3,4,10};
        int k = 5;
        AllocateMaximumCandies_2226 sol = new AllocateMaximumCandies_2226();
        System.out.println(sol.maximumCandies(candies, k));
    }
}
