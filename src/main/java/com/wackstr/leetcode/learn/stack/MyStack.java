package com.wackstr.leetcode.learn.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> queue2;

    public MyStack() {
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        while(queue.size() > 1){
            queue2.add(queue.poll());
        }
        int res = queue.poll();
        Queue<Integer> temp = queue2;
        queue2 = queue;
        queue = temp;
        return res;
    }

    public int top() {
        while(queue.size() > 1){
            queue2.add(queue.poll());
        }
        int res = queue.poll();
        queue2.add(res);
        Queue<Integer> temp = queue2;
        queue2 = queue;
        queue = temp;
        return res;
    }

    public boolean empty() {
        return queue.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
