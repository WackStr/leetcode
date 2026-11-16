package com.wackstr.leetcode;

/*
2026-11-16 2243
 */
public class DigitSum_2243 {
    public String digitSum(String s, int k) {

        while(s.length() > k){
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for(int i = 1; i <=s.length(); i++){
                sum += s.charAt(i-1) - '0';
                if(i % k == 0 || i == s.length()){
                    sb.append(sum);
                    sum=0;
                }
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "00000000";
        int k = 3;
        DigitSum_2243 sol = new DigitSum_2243();
        System.out.println(sol.digitSum(s, k));

    }
}
