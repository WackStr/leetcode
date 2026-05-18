package com.wackstr.leetcode;

import java.util.*;

/*
2026-05-18 1345
 */
public class JumpGames_1345 {
    public int minJumps(int[] arr){
        if(arr.length == 1) return 0;
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            indices.computeIfAbsent(num, k->new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int steps = 0;
        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();
            while(size > 0){
                int curr = queue.poll();
                if(curr > 0 && !visited[curr - 1]){
                    visited[curr - 1] = true;
                    queue.add(curr - 1);
                }
                if(curr < n-1 && !visited[curr+1]){
                    if(curr == n - 2) return steps;
                    visited[curr + 1] = true;
                    queue.add(curr + 1);
                }
                if(indices.containsKey(arr[curr])){
                    for (Integer i : indices.get(arr[curr])) {
                        if(!visited[i]){
                            if(i == n - 1) return steps;
                            visited[i] = true;
                            queue.add(i);
                        }
                    }
                    indices.remove(arr[curr]);
                }
                size--;
            }
        }
        return n-1;
    }
}
