package com.wackstr.leetcode.learn.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private record Node(int val, int min){}

    List<Node> stack;

    public MinStack(){
        this.stack = new ArrayList<>();
    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.add(new Node(val, val));
        }else {
            stack.add(new Node(val, Math.min(topNode().min(), val)));
        }
    }

    public void pop(){
        stack.remove(stack.size() - 1);
    }

    public int top(){
        return topNode().val();
    }

    private Node topNode(){
        return stack.get(stack.size() - 1);
    }

    public int getMin(){
        return topNode().min();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-1);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
