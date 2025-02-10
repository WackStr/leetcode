package com.wackstr.leetcode;

import java.util.Arrays;

public class ProductDistribution_2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < quantities.length; i++){
            if(quantities[i] > right) right = quantities[i];
        }

        if(n == quantities.length){
            return right;
        }

        while(left < right){
            int mid = left + (right - left)/2;
            if(canDistribute(mid, n, quantities)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canDistribute(int k, int n, int[] quantities){
        int j = 0;
        int remaining = quantities[j];
        for(int i = 0; i < n; i++){
            if(remaining <= k){
                j++;
                if(j == quantities.length){
                    return true;
                }
                remaining = quantities[j];
            }else{
                remaining -= k;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] quantities = {15,10,10};
        int n = 7;
        ProductDistribution_2064 sol = new ProductDistribution_2064();
        System.out.println(sol.minimizedMaximum(n, quantities));
    }
}
