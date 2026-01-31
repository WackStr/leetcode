package com.wackstr.leetcode;

/*
2026-01-31 744
 */
public class LargerCharacter_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters[letters.length - 1] <= target) return letters[0];
        int left = 0;
        int right = letters.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(letters[mid] > target) right = mid;
            else left = mid + 1;
        }
        return letters[left];
    }
}
