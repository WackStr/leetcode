package com.wackstr.leetcode.learn.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReversePolishNotation {
    private static final Set<String> ops = new HashSet<>(Arrays.asList(
            "+", "-", "/", "*"
    ));
    
    public int evalRPN(String[] tokens){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if(ops.contains(token)){
                // do operation
                int val2 = stack.pollLast();
                int val1 = stack.pollLast();
                stack.offerLast(switch (token) {
                    case "+" -> val1 + val2;
                    case "-" -> val1 - val2;
                    case "*" -> val1 * val2;
                    case "/" -> val1 / val2;
                    default -> throw new IllegalArgumentException("Unknown operator: " + token);
                });
            }else{
                stack.offerLast(Integer.valueOf(token));
            }
        }
        return stack.poll();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        ReversePolishNotation sol = new ReversePolishNotation();
        System.out.println(sol.evalRPN(tokens));
    }
}
