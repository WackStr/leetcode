package com.wackstr.leetcode.learn;

import java.util.*;

public class TopologicalSort {
    public int[] topologicalSort(int n, int[][] edges) {
        int[] topologicallySorted = new int[n];
        int[] degree = new int[n];
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            degree[to]++;
            adjacency.computeIfAbsent(from, v -> new ArrayList<>()).add(to);
        }
        Queue<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) stack.add(i);
        }
        int currIndex = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                int node = stack.poll();
                if (adjacency.containsKey(node)) {
                    for (int adjNode : adjacency.get(node)) {
                        degree[adjNode]--;
                        if (degree[adjNode] == 0) stack.add(adjNode);
                    }
                }
                topologicallySorted[currIndex++] = node;
            }
        }
        return topologicallySorted;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}};
        TopologicalSort sol = new TopologicalSort();
        System.out.println(Arrays.toString(sol.topologicalSort(n, edges)));
    }
}
