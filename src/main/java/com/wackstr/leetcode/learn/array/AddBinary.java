package com.wackstr.leetcode.learn.array;

public class AddBinary {

    /*
    Given two binary strings a and b, return their sum as a binary string.
     */
    public String addBinary(String a, String b){
        boolean carry = false;
        /*
        create char array with length that holds the max length of a and b
         */
        int n = Math.max(a.length(), b.length());
        char[] str = new char[n];
        // since we are doing sum go from right to left
        for(int i = 0; i < n; i++){
            // get bit flags to get carry and sum using boolean algebra
            boolean bA = getBitFlag(a, i);
            boolean bB = getBitFlag(b, i);
            // given the carry and current bits, sum is given by xor
            str[n - i  - 1] = bA ^ bB ^ carry ? '1' : '0';
            // carry is one if both flags are 1 or if any is 1 and carry is 1
            carry = (bA && bB) || (carry && (bA || bB));
        }
        StringBuilder sb = new StringBuilder();
        // account for overflow bit if we are left with any carry
        if(carry) sb.append('1');
        sb.append(str);
        return sb.toString();
    }

    /*
        for an index measuring from right side on a string
        return true if char is 1 else false
        if reverseIndex is greater than length of string, return false
     */
    public boolean getBitFlag(String s, int reverseIndex){
        int index = s.length() - reverseIndex - 1;
        return (index >= 0 ? s.charAt(index) : '0') == '1';
    }

    public static void main(String[] args) {
        String a = "0", b = "0";
        AddBinary sol = new AddBinary();
        System.out.println(sol.addBinary(a, b));
    }
}
