package com.wackstr.leetcode;

/*
2025-04-11
 */
public class SymmetricIntegers_2843 {
    public int countSymmetricIntegers(int low, int high){
        int cnt = 0;
        for(int num = low; num <= high; num++){
            String s = String.valueOf(num);
            if(s.length() % 2 == 0){
                int left =
                        Integer.parseInt(s.substring(0, s.length()/2));
                int right =
                        Integer.parseInt(s.substring(s.length()/2));
                if(sum(left) == sum(right)) cnt++;
            }
        }
        return cnt;
    }

    private int sum(int left) {
        int sum = 0;
        while(left > 0){
            sum += left % 10;
            left /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int low = 1, high = 100;
        SymmetricIntegers_2843 sol = new SymmetricIntegers_2843();
        System.out.println(sol.countSymmetricIntegers(low, high));
    }
}
