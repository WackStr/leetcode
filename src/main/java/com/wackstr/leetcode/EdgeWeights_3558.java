package com.wackstr.leetcode;

import java.util.*;

/*
2026-06-11 3558
 */
public class EdgeWeights_3558 {
    private static final Map<Integer, Integer> lookup = new HashMap<>();
    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        /*
        build adjacency graph
        get depth
        solve on depth dynamically
        store in a static variable
         */
        // builds the adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // do a level by level bfs to get depth of tree
        int n = edges.length;
        boolean[] visited = new boolean[n+2];
        Queue<Integer> stack = new LinkedList<>();
        stack.offer(1);
        visited[1] = true;
        int depth = 0;
        while(!stack.isEmpty()){
            int len = stack.size();
            while(len > 0){
                int curr = stack.poll();
                for (Integer neighbor : graph.get(curr)) {
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        stack.offer(neighbor);
                    }
                }
                len--;
            }
            depth++;
        }

        // solve on tree
        if(!lookup.containsKey(depth)) {
            int[] dp = new int[depth];
            if(depth >= 2) {
                dp[depth - 2] = 1;
                for (int i = depth - 3; i >= 0; i--) {
                    dp[i] = (dp[i + 1] + dp[i + 1]) % MOD;
                }
            }
            lookup.put(depth, dp[0]);
        }
        return lookup.get(depth);
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {3,4}, {3,5}};
        EdgeWeights_3558 sol = new EdgeWeights_3558();
        System.out.println(sol.assignEdgeWeights(edges));
    }
}
