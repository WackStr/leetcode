package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
2025-05-12
 */
public class ThreeDigitEven_2094 {
    public int[] findEvenNumbers(int[] digits){
        int[] cnt = new int[10];
        for(int digit : digits){
            cnt[digit]++;
        }
        int[] currCount = new int[10];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 100; i <= 998; i+= 2){
            Arrays.fill(currCount, 0);
            int n = i;
            while(n > 0){
                currCount[n%10]++;
                n /= 10;
            }
            boolean canCreate = true;
            for(int j = 0; j < 10; j++){
                if(currCount[j] > cnt[j]) {
                    canCreate = false;
                    break;
                }
            }
            if(canCreate) res.add(i);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] digits = {2, 2, 8, 8, 2};
        ThreeDigitEven_2094 sol = new ThreeDigitEven_2094();
        System.out.println(Arrays.toString(sol.findEvenNumbers(digits)));
    }
}
