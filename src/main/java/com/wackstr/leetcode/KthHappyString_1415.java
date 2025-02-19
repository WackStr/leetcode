package com.wackstr.leetcode;

/*
2025-02-19
 */
public class KthHappyString_1415 {
    public String getHappyString(int n, int k){
        // eliminate out of bounds condition
        if(isOutOfBounds(n, k)) return "";
        // n == 1 is a simple case, no need to compute
        if(n == 1) return "" + getFirstChar(k - 1);

        /*
            in an ordered tree, find the change in directions
            n[0] selects between a,b,c
            n[i] = 0 | 1 chooses the smaller | larger of the
            two choices compared to char at i - 1
                       root
                   /    |     \
                a       b       c
              /   \   /   \   /   \
             b    c  a    c   a    b
             1    2  3    4   5    6 <--- final string in ordering
             ab   ac ba   bc  ca   cb
         */
        int[] chars = getCharDirections(n, k);

        // using the above mapping , convert to final string
        return convertToString(chars);
    }

    private static boolean isOutOfBounds(int n, int k) {
        return k > getTotalStrings(n);
    }

    private static int getTotalStrings(int n) {
        /*
         3 * 2^(n-1). The first level has 3 chars, then there are two options
         for each level to maintain a happy string
         */
        return 3 * (1 << (n - 1));
    }

    private static int[] getCharDirections(int n, int k) {
        int[] chars = new int[n];
        /* account for 1-indexing the even/odd parity tells us whether to go
          for smaller or larger option.
          Then at each step we get the quotient after dividing by 2 to get the
          index of the character at each level (adjust for 1-indexing first time)
          like before even/odd parity tells us whether to go for larger or
          smaller option
         */
        chars[n - 1] =  (k - 1) % 2;
        int next = (k - 1) / 2;
        for(int i = n - 2; i >= 0; i--){
            chars[i] = i > 0 ? next % 2 : next; // base case just select the index
            next /= 2;
        }
        return chars;
    }

    private static String convertToString(int[] chars) {
        StringBuilder sb = new StringBuilder();
        char latestChar = getFirstChar(chars[0]);
        sb.append(latestChar);
        for(int i = 1; i < chars.length; i++){
            latestChar = getNextChar(latestChar, chars[i]);
            sb.append(latestChar);
        }
        return sb.toString();
    }

    private static char getFirstChar(int i) {
        if (i == 0) {
            return 'a';
        } else if (i == 1) {
            return 'b';
        }else{
            return 'c';
        }
    }

    private static char getNextChar(char lastChar, int movement) {
        /*
        movement 0 means take the smaller option
        movement 1 means take the larger option
        the conditions are simplified here
         */
        if(movement == 0){
            return lastChar == 'a' ? 'b' : 'a';
        }else{
            return lastChar == 'c' ? 'b' : 'c';
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 9;
        KthHappyString_1415 sol = new KthHappyString_1415();
        System.out.println(sol.getHappyString(n, k));
    }
}
