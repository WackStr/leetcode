package com.wackstr.leetcode.learn.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Temperature {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] days = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            if(stack.isEmpty()) {
                days[i] = 0;
            }else{
                while(!stack.isEmpty() &&
                        temperatures[stack.peekFirst()] <= temperatures[i]) {
                    stack.pollFirst();
                }
                days[i] = stack.isEmpty() ? 0 : stack.peekFirst() - i;

            }
            stack.offerFirst(i);
        }
        return days;
    }

    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        Temperature sol = new Temperature();
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures)));
    }
}
