package com.wackstr.leetcode;

/*
2025-04-23
 */
public class CountLargestGroup_1399 {
    public int countLargestGroup(int n){
        int maxSize = 0;
        int[] groups = new int[37];
        for(int i = 1; i <= n; i++){
            int curr = i;
            int sum = 0;
            while(curr > 0){
                sum += curr % 10;
                curr /= 10;
            }
            groups[sum]++;
            maxSize = Math.max(maxSize, groups[sum]);
        }
        int maxSizeGroups = 0;
        for(int i = 1; i < 37; i++){
            if(groups[i] == maxSize) maxSizeGroups++;
        }
        return maxSizeGroups;
    }

    public static void main(String[] args) {
        int n = 13;
        CountLargestGroup_1399 sol = new CountLargestGroup_1399();
        System.out.println(sol.countLargestGroup(n));
    }
}
