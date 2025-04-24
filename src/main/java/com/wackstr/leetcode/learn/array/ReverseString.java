package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class ReverseString {
    /*
        Write a function that reverses a string. The input string is given as
        an array of characters s.

        You must do this by modifying the input array in-place with O(1)
        extra memory.
     */
    public void reverseString(char[] s){
        int left = -1;
        int right = s.length;
        while(++left < --right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        ReverseString sol = new ReverseString();
        sol.reverseString(s);
        System.out.println(Arrays.toString(s));
    }


}
