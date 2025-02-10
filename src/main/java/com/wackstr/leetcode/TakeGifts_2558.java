package com.wackstr.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
2024-12-12
 */
public class TakeGifts_2558 {
    public long pickGifts(int[] gifts, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int gift: gifts){
            queue.add(gift);
        }
        for(int i = 0; i < k; i++){
            int gift = queue.poll();
            queue.add((int) Math.sqrt(gift));
        }
        long sum = 0;
        for(int gift : queue){
            sum += gift;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        TakeGifts_2558 sol = new TakeGifts_2558();
        System.out.println(sol.pickGifts(gifts, k));
    }
}
