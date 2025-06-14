package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2025-05-26
 */
public class GraphLargestColorValue_1857 {
    private List<List<Integer>> graph;
    private String colors;
    private int[][] dp;
    private int[] visited;

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        this.colors = colors;
        this.graph = new ArrayList<>();
        this.dp = new int[n][26];
        this.visited = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
        }

        int maxColorValue = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && hasCycleAndUpdateDP(i)) {
                return -1;
            }

            for (int c = 0; c < 26; c++) {
                maxColorValue = Math.max(maxColorValue, dp[i][c]);
            }
        }
        return maxColorValue;
    }

    private boolean hasCycleAndUpdateDP(int node) {
        if (visited[node] == 1) return true;
        if (visited[node] == 2) return false;

        visited[node] = 1;

        for (int neighbor : graph.get(node)) {
            if (hasCycleAndUpdateDP(neighbor)) {
                return true;
            }

            for (int c = 0; c < 26; c++) {
                dp[node][c] = Math.max(dp[node][c], dp[neighbor][c]);
            }
        }

        int currentColor = colors.charAt(node) - 'a';
        dp[node][currentColor]++;

        visited[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        String colors = "abaca";
        int[][] edges = {{0,1}, {0,2}, {2,3}, {3,4}};
        GraphLargestColorValue_1857 sol = new GraphLargestColorValue_1857();
        System.out.println(sol.largestPathValue(colors, edges));
    }
}
