package com.wackstr.leetcode;

/*
2025-07-16
 */
public class ValidSubsequence_3201 {


    public int maximumLength(int[] nums) {
        /*
        Either take all even, all odd, or alternating parities
        count all three categories in one loop
         */
        int evenCount = 0;
        int oddCount = 0;
        int alternateCount = 1; // we are greedily taking the first number
        int currParity = nums[0] & 1;

        // handle parity of first case to simplify the loop later
        if(currParity == 0)
            evenCount++;
        else
            oddCount++;

        for(int i = 1; i < nums.length; i++){
            int nextParity = nums[i] & 1;
            if(nextParity == 0)
                evenCount++;
            else
                oddCount++;
            alternateCount += (nextParity != currParity) ? 1 : 0;
            currParity = nextParity;
        }
        return Math.max(Math.max(evenCount, oddCount), alternateCount);
    }

    public static void main(String[] args) {

    }
}
