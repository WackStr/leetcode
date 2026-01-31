package com.wackstr.leetcode.learn.stack;


import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> stack2;
    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

    }

    public int pop() {
        invert();
        return stack2.pop();
    }

    public int peek() {
        invert();
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack.isEmpty();
    }

    private void invert(){
        if(stack2.isEmpty())
            while(!stack.isEmpty())
                stack2.push(stack.pop());
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        q.push(5);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }
}
