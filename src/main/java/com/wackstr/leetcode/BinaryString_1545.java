package com.wackstr.leetcode;

/*
2026-03-03 1545
 */
public class BinaryString_1545 {
    public char findKthBit(int n, int k){
        int N = (1 << n) - 1;
        char[] chars = new char[N];
        chars[N - 1] = '0';
        int oldLength = 1;
        for(int i = 2; i <= n; i++){
            int newLength = (1 << i) - 1;
            // copy the chars
            for(int j = N - newLength; j < N-oldLength - 1; j++){
                chars[j] = chars[j + oldLength + 1];
            }
            // add the 1
            chars[N-oldLength-1] = '1';
            //flip the chars
            for(int a = N - oldLength; a < N; a++){
                chars[a] = chars[a] == '0' ? '1' : '0';
            }
            //revers the segment
            for(int a = N - oldLength, b = N - 1; a < b; a++, b--){
                swap(chars, a, b);
            }
            oldLength = newLength;
        }
        return chars[k-1];
    }

    private void swap(char[] chars, int a, int b) {
        char c = chars[a];
        chars[a] = chars[b];
        chars[b] = c;
    }

    public static void main(String[] args) {
        int n = 3, k = 1;
        BinaryString_1545 sol = new BinaryString_1545();
        System.out.println(sol.findKthBit(n, k));
    }
}
