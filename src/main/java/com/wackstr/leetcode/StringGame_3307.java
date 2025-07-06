package com.wackstr.leetcode;

/*
2025-07-04
 */
public class StringGame_3307 {
    public char kthCharacter(long k, int[] operations){
        // get power of 2 just less than k
        if(k == 1) return 'a';
        long temp = 1;
        int n = 0;
        while(temp < k) {
            n++;
            temp <<= 1;
        }
        temp >>= 1;

        // apply = is k in second half
        boolean apply = k > temp;
        // if in second half subtract midpoint to get offSet
        long offSet = apply ? k - temp : k;
        return getChar(apply,n - 1, offSet, operations);
    }

    private char getChar(
            boolean apply, int level, long remainder, int[] operations) {
        if(level <= 0){
            if(!apply) return 'a';
            else return operations[0] == 0 ? 'a' : 'b';
        } else {
            // num = 2 ^ n
            int n = level;
            long num = 1;
            while (n-- > 0) {
                num <<= 1;
            }
            num >>= 1;

            boolean nextApply = remainder > num;
            long nextRemainder = nextApply ? remainder - num : remainder;
            char c = getChar(
                    nextApply,level - 1,
                    nextRemainder, operations);

            if(!apply || operations[level] == 0) return c;
            else return c == 'z' ? 'a' : (char)(c + 1);
        }
    }

    public static void main(String[] args) {
        int[] operations = {1,1,1};
        int k = 7;
        StringGame_3307 sol = new StringGame_3307();
        System.out.println(sol.kthCharacter(k, operations));
    }
}
