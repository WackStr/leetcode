package com.wackstr.leetcode;

/*
3133
 */
public class MinimumBitwiseAndIncrementalArrayEnd {
    public long minEnd(int n, int x) {
        return minEndLogN(n, x);
    }

    public long minEndN(int n, int x){
        int currMin = x;
        for(int i = 1; i < n; i++){
            currMin += 1;
            currMin |= x;
        }
        return currMin;
    }

    public long minEndLogN(int n, int x){
        long result = x;
        long mask;
        n--; // Reducing n by 1 to exclude x from the iteration

        // Step 1: Iterate over each bit position with mask starting at 1 and shifting left
        for (mask = 1; n > 0; mask <<= 1) {
            // Step 2: If the corresponding bit in x is 0
            if ((mask & x) == 0) {
                // Set the bit in result based on the least significant bit of n
                result |= (n & 1) * mask;
                // Shift n to the right by 1 to process the next bit
                n >>= 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumBitwiseAndIncrementalArrayEnd sol =
                new MinimumBitwiseAndIncrementalArrayEnd();
        int n = 2;
        int x = 7;
        System.out.println(sol.minEnd(n,x));
    }
}
