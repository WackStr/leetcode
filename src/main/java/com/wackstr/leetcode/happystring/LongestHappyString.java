package com.wackstr.leetcode.happystring;

import java.util.PriorityQueue;

/*
Problem number 1405
 */
public abstract class LongestHappyString {

    record StringRepresentation (String str, int cnt) {}

    public abstract String longestDiverseString(int a, int b, int c);

    static PriorityQueue<StringRepresentation>
    initializePriorityQueue(int a, int b, int c) {
        PriorityQueue<StringRepresentation> queue =
                new PriorityQueue<>((t,u) -> Integer.compare(u.cnt(), t.cnt()));
        queue.add(new StringRepresentation("a", a));
        queue.add(new StringRepresentation("b", b));
        queue.add(new StringRepresentation("c", c));
        return queue;
    }

    public static void main(String[] args) {
        LongestHappyString sol = new LongestHappyStringLinkedList();
        System.out.println(sol.longestDiverseString(1, 1, 7));
    }
}
