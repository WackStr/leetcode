package com.wackstr.leetcode;

/*
2025-08-14
 */
public class ThreeSameDigit_2264 {
    public String largestGoodInteger(String num){
        boolean[] checked = new boolean[10];
        int currCount = 1;
        char curr = num.charAt(0);
        int max = -1;
        for(int i = 1; i < num.length(); i++){
            if(num.charAt(i) == curr){
                currCount++;
                if(currCount == 3){
                    int base = curr - '0';
                    if(!checked[base]) {
                        int candidate = base + 10 * base + 100 * base;
                        checked[base] = true;
                        max = Math.max(max, candidate);
                    }
                }
            }else{
                curr = num.charAt(i);
                currCount = 1;
            }
        }
        return switch (max) {
            case -1 -> "";
            case 0  -> "000";
            default -> String.valueOf(max);
        };
    }

    public static void main(String[] args) {
        String num = "42352338";
        ThreeSameDigit_2264 sol = new ThreeSameDigit_2264();
        System.out.println(sol.largestGoodInteger(num));
    }
}
