package com.wackstr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
2026-05-17 1306
 */
public class JumpGames_1306 {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] <0) return false;
        if(arr[start] == 0) return true;
        arr[start] = -arr[start];
        return canReach(arr,start+arr[start]) || canReach(arr, start-arr[start]);
    }

    private static boolean bfs(int[] arr, int start) {
        if(arr[start] == 0) return true;
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int i = queue.poll();
                int back = i - arr[i];
                int front = i + arr[i];
                if(front < n && !visited[front]) {
                    if(arr[front] == 0) return true;
                    queue.add(front);
                    visited[front] = true;
                }
                if(back >= 0 && !visited[back]) {
                    if(arr[back] == 0) return true;
                    queue.add(back);
                    visited[back] = true;
                }
                size--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0,1};
        int  start = 1;
        JumpGames_1306 sol = new JumpGames_1306();
        System.out.println(sol.canReach(arr, start));
    }
}
