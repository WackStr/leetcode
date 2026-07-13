package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2026-07-13
 */
public class SequentialDigits_1291 {
    public List<Integer> sequentialDigits(int low, int high){
        List<Integer> res = new ArrayList<>();
        int[] digits = {1, 2, 0, 0, 0, 0, 0, 0, 0};
        int right = 1;
        int curr = 12;
        while(curr <= high){
            if(curr >= low)
                res.add(curr);
            if(digits[right] == 9){
                right++;
                if(right > 8) break;
                for(int i = 0; i <= right; i++){
                    digits[i] = i + 1;
                }
            }else{
                for(int i = 0; i <= right; i++){
                    digits[i]++;
                }
            }
            curr = digits[0];
            for(int k = 1; k <= right; k++){
                curr *=10;
                curr += digits[k];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int low = 123, high = 123;
        SequentialDigits_1291 sol = new SequentialDigits_1291();
        System.out.println(sol.sequentialDigits(low, high).size());
    }
}
