package com.wackstr.leetcode;

import java.util.*;

/*
2024-11-27
 */
public class ShortestDistanceAfterRoadAddition_3243 {
    public int[] shortestDistanceAfterQueries(int n, int[][]queries){
        int[] ans = new int[queries.length];

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < n - 1; i++){
            List<Integer> nextNode = new ArrayList<>();
            nextNode.add(i+1);
            adjacencyList.put(i, nextNode);
        }
        adjacencyList.put(n - 1, new ArrayList<>());

        for(int i = 0; i < queries.length; i++){
            int[] road = queries[i];
            adjacencyList.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
            // Dijkstra to the rescue
            int shortestPath = getShortestPath(adjacencyList);
            ans[i] = shortestPath;
        }
        return ans;
    }

    /*
    all nodes are not visited
    pick node with shortest distance u
    update distance of all neighbors v
           d(0-v) = min(d(0-v), d(0-u) + d(u-v)) = min(d(0-v), d(0-u) + 1)

     */
    private int getShortestPath(
            Map<Integer, List<Integer>> adjacencyList) {
        int n = adjacencyList.keySet().size();
        int[] shortestPaths = new int[n];
        boolean[] visitedNodes = new boolean[n];

        shortestPaths[0] = 0;
        for(int i = 1; i < n; i++){
            shortestPaths[i] = n + 1;
        }

        for(int i = 0; i < n; i++){
            int u = getMinimumNode(shortestPaths, visitedNodes);
            for(int v : adjacencyList.get(u)){
                shortestPaths[v] = Math.min(shortestPaths[u] + 1, shortestPaths[v]);
            }
            visitedNodes[u] = true;
        }
        return shortestPaths[n - 1];
    }

    private int getMinimumNode(int[] shortestPaths, boolean[] visitedNodes) {
        int minDistance = visitedNodes.length + 1;
        int minimumNode = -1;
        for(int i = 0; i < visitedNodes.length; i++){
            if(!visitedNodes[i] && shortestPaths[i] < minDistance){
                minDistance = shortestPaths[i];
                minimumNode = i;
            }
        }
        return minimumNode;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{2,4}, {0,2}, {0,4}};
        ShortestDistanceAfterRoadAddition_3243 sol =
                new ShortestDistanceAfterRoadAddition_3243();
        System.out.println(Arrays.toString(
                sol.shortestDistanceAfterQueries(n, queries)));
    }
}
