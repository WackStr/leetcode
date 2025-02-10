package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/*
2025-01-11
 */
public class ConstructKPalindromes_1400 {
    public boolean canConstruct(String s, int k) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            characterCounts.merge(s.charAt(i), 1, Integer::sum);
        }

        Queue<int[]> evenStack = new ArrayDeque<>();
        Queue<int[]> oddStack = new ArrayDeque<>();
        for(Character c : characterCounts.keySet()){
            int currCount = characterCounts.get(c);
            int[] rep = {c, currCount};
            if((currCount & 1) == 1){
                oddStack.add(rep);
            }else{
                evenStack.add(rep);
            }
        }
        for(int i = 0; i < k; i++){
            if(!oddStack.isEmpty()){
                int[] stack = oddStack.poll();
                if(stack[1] > 1){
                    evenStack.add(new int[]{stack[0], stack[1] - 1});
                }
            }else{
                if(evenStack.isEmpty()){
                    return false;
                }else{
                    int sum = 0;
                    while(!evenStack.isEmpty()){
                        sum += evenStack.poll()[1];
                    }
                    return (k-i) <= sum;
                }
            }
        }
        return oddStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        ConstructKPalindromes_1400 sol = new ConstructKPalindromes_1400();
        System.out.println(sol.canConstruct(s, k));
    }
}
