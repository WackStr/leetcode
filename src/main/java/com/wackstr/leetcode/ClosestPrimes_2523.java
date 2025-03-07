package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2025-03-07
 */
public class ClosestPrimes_2523 {

    public int[] closestPrimes(int left, int right){
        if(left == right) return new int[]{-1, -1};
        Integer[] primes = getPrimes(right);
        int leftMatch = Arrays.binarySearch(primes, left);
        int rightMatch = Arrays.binarySearch(primes, right);
        int leftIndex = leftMatch < 0 ? -leftMatch - 1 : leftMatch;
        int rightIndex = rightMatch < 0 ? -rightMatch - 2: rightMatch;

        int[] ans = {-1, -1};
        int minDistance = Integer.MAX_VALUE;
        if(leftIndex == rightIndex) {
            ans = new int[]{-1, -1};
        } else {
            for(int i = leftIndex; i < rightIndex; i++) {
                if(primes[i+1] - primes[i] <= 2){
                    ans = new int[]{primes[i], primes[i+1]};
                    break;
                }else{
                    int currDistance = primes[i+1] - primes[i];
                    if(currDistance < minDistance){
                        ans = new int[]{primes[i], primes[i+1]};
                        minDistance = currDistance;
                    }
                }
            }
        }
        return ans;
    }

    public static Integer[] getPrimes(int n){
        int[] init = new int[n - 1];
        for(int i = 0; i < n - 1; i++){
            init[i] = i+2;
        }

        int pointer = 0;
        while(pointer < n){
            while(pointer < n - 1 && init[pointer] == 0) pointer++;
            if(pointer < n - 1){
                int delta = init[pointer];
                for(int i = pointer + delta; i < n - 1; i+=delta){
                    init[i] = 0;
                }
            }
            pointer++;
        }

        List<Integer> finalArray = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            if(init[i] != 0) finalArray.add(init[i]);
        }
        return finalArray.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int left = 1;
        int right = 1000000;
        ClosestPrimes_2523 sol = new ClosestPrimes_2523();
        System.out.println(Arrays.toString(sol.closestPrimes(left, right)));
    }
}
