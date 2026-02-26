package com.wackstr.leetcode;

/*
2026-02-26 1404
 */
public class BinaryReduction_1404 {
    public int numSteps(String s){
        int N = s.length();

        int operations = 0;
        int carry = 0;
        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                operations += 2;
                carry = 1;
            } else {
                operations++;
            }
        }

        return operations + carry;
    }

    public static void main(String[] args) {
        String s = "1101";
        BinaryReduction_1404 sol = new BinaryReduction_1404();
        System.out.println(sol.numSteps(s));
    }
}
