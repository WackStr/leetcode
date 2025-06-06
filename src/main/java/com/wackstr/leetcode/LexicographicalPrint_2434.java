package com.wackstr.leetcode;

import java.util.ArrayDeque;

/*
2025-06-06
 */
public class LexicographicalPrint_2434 {
    public String robotWithString(String s) {

        int[] arr = new int[s.length()]; // arr[i] = smallest character's index for s[i:]
        ArrayDeque<Character> chars = new ArrayDeque<>(); // holding LIFO order characters picked by robot
        StringBuilder res = new StringBuilder(); // building final answer
        char curr = 'z' + 1;
        char nextTarget;
        int i = s.length() - 1;
        int k = 1;
        int nextIndex;
        int j;

        /*
            arr[i] represents smallest character index for s[i:]
            move right to left on string s to populate while tracking
            running min char and index
         */
        while(i >= 0){
            if(s.charAt(i) <= curr){
                curr = s.charAt(i);
                k = i;
            }
            arr[i] = k;
            i--;
        }

        i = 0;
        while(i < arr.length) {

            /*
            append the smallest character available in s[i:]
            fill the LIFO stack with the characters up to the index (nextIndex)
            of this smallest character
             */
            nextIndex = arr[i];
            res.append(s.charAt(nextIndex));
            j = i;
            while(j < nextIndex){
                chars.offer(s.charAt(j));
                j++;
            }

            /*
            If there are characters available after the character just added
            it is possible that we have picked up characters in our LIFO stack
            which are smaller than the next smallest character in s[nextIndex:]
            release these characters into the final result first
             */
            if(nextIndex < arr.length - 1) {
                nextTarget = s.charAt(arr[nextIndex + 1]);
                while (!chars.isEmpty()) {
                    if (chars.peekLast() <= nextTarget) {
                        res.append(chars.pollLast());
                    } else {
                        break;
                    }
                }
            }
            // move counter ahead of all characters processed
            i = nextIndex + 1;
        }
        // append any remainder characters in LIFO order
        while(!chars.isEmpty()){
            res.append(chars.pollLast());
        }
        return res.toString();
    }

    public static void main(String[] args) {//
        String s = "bydizfve"; // fnohopzv
        LexicographicalPrint_2434 sol = new LexicographicalPrint_2434();
        System.out.println(sol.robotWithString(s));
    }
}
