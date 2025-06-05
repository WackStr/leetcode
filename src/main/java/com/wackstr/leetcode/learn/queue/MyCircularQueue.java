package com.wackstr.leetcode.learn.queue;

public class MyCircularQueue {
    private int[] buffer;
    private int tail;
    private int head;
    private int size;

    public MyCircularQueue(int k) {
        buffer = new int[k];
        tail = 0;
        head = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        buffer[tail] = value;
        tail = (tail + 1) % buffer.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        head = (head + 1) % buffer.length;
        size--;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return buffer[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return buffer[(tail+ buffer.length - 1)% buffer.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(4));
        System.out.println(q.Rear());
        System.out.println(q.isFull());
        System.out.println(q.Front());
        System.out.println(q.deQueue());
        System.out.println(q.enQueue(4));
        System.out.println(q.Rear());
        System.out.println(q.Front());

    }
}
