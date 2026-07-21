package com.wackstr.leetcode;

/*
2026-07-21 3499
 */
public class ActiveSections_3499 {
    public int maxActiveSectionsAfterTrade(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0;
        int oneCount = 0;
        int maxConversion = 0;
        int leftZeroes = 0;
        while (left < n && arr[left] == '1') {
            oneCount++;
            left++;
        }
        while (left < n && arr[left] == '0') {
            left++;
            leftZeroes++;
        }
        while(left < n) {
            int rightZeroes = 0;
            while (left < n && arr[left] == '1') {
                oneCount++;
                left++;
            }
            while (left < n && arr[left] == '0') {
                left++;
                rightZeroes++;
            }
            if(leftZeroes > 0 && rightZeroes > 0)
                maxConversion = Math.max(maxConversion, leftZeroes + rightZeroes);
            leftZeroes = rightZeroes;
        }
        return oneCount + maxConversion;
    }

    public static void main(String[] args) {
        String s = "01010";
        ActiveSections_3499 sol = new ActiveSections_3499();
        System.out.println(sol.maxActiveSectionsAfterTrade(s));
    }
}
