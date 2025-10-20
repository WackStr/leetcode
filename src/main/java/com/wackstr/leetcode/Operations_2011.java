package com.wackstr.leetcode;

/*
2025-10-20
 */
public class Operations_2011 {
    public int finalValueAfterOperations(String[] operations){
        int res = 0;
        for (String op : operations) {
            if(op.charAt(1) == '+') res++;
            else res--;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] operations = {"--X","X++","X++"};
        Operations_2011 sol = new Operations_2011();
        System.out.println(sol.finalValueAfterOperations(operations));
    }
}
