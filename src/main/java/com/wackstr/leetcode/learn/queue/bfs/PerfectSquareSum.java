package com.wackstr.leetcode.learn.queue.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquareSum {

    private static final int[] SQUARE_SUMS;

    static {
        SQUARE_SUMS = new int[100];
        for(int i = 1; i <= 100; i++){
            SQUARE_SUMS[i-1] = i * i;
        }
    }

    public int numSquares(int n){
        boolean[] visited = new boolean[10001];
        int steps = 0;
        int cnt;
        int next;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            cnt = queue.size();
            while(cnt > 0){
                int curr = queue.poll();
                if(curr == n) return steps;
                for(int i = 0; i < 100; i++){
                    next = curr + SQUARE_SUMS[i];
                    if(next > n) break;
                    if(!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                cnt--;
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 12;
        PerfectSquareSum sol = new PerfectSquareSum();
        System.out.println(sol.numSquares(n));
    }
}
