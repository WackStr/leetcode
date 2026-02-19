package com.wackstr.leetcode;

/*
2026-02-19 696
 */
public class BinarySubString_696 {
    public int countBinarySubstrings(String s){
        int n = s.length();
        int curr = 1;
        int prev = 0;
        int sum=0;

        for(int i=1; i<n; i++){
            if(s.charAt(i)==s.charAt(i-1)){
                curr++;
            }else{
                sum += Math.min(curr,prev);
                prev = curr;
                curr=1;
            }

        }
        sum += Math.min(curr,prev);

        return sum;
    }

    public static void main(String[] args) {
        String s = "10";
        BinarySubString_696 sol = new BinarySubString_696();
        System.out.println(sol.countBinarySubstrings(s));
    }
}
