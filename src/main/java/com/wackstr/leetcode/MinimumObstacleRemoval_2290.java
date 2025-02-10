package com.wackstr.leetcode;

import java.util.*;

/*
2024-11-28
 */
public class MinimumObstacleRemoval_2290 {

    public int minimumObstacles(int[][] grid){
        Map<Integer, List<int[]>> adjacencyList =
                convertToAdjacenyList(grid);
        return getShortestPath(adjacencyList);
    }

    private Map<Integer, List<int[]>> convertToAdjacenyList(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int totalNodes = rows * columns;
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for(int currNode = 0; currNode < totalNodes; currNode++){
            List<int[]> neighbors = new ArrayList<>();
            int col = currNode % columns;
            int row = currNode/columns;

            // up
            if(row > 0){
                int[] neighbor = {row - 1, col};
                insertNode(grid, neighbor, neighbors);
            }
            //left
            if(col > 0){
                int[] neighbor = {row, col - 1};
                insertNode(grid, neighbor, neighbors);
            }
            //right
            if(col < columns - 1){
                int[] neighbor = {row, col + 1};
                insertNode(grid, neighbor, neighbors);
            }
            //down
            if(row < rows - 1){
                int[] neighbor = {row + 1, col};
                insertNode(grid, neighbor, neighbors);
            }

            adjacencyList.put(currNode, neighbors);
        }
        return adjacencyList;
    }


    private void insertNode(
            int[][] grid,
            int[] cell,
            List<int[]> nodes){
        int weight = grid[cell[0]][cell[1]];
        nodes.add(new int[]{
                cell[0] * grid[0].length + cell[1]
                , weight});
    }

    private int getShortestPath(
            Map<Integer, List<int[]>> adjacencyList) {
        int n = adjacencyList.keySet().size();
        int[] shortestPaths = new int[n];
        boolean[] visitedNodes = new boolean[n];

        shortestPaths[0] = 0;
        for(int i = 1; i < n; i++){
            shortestPaths[i] = n + 1;
        }

        for(int i = 0; i < n; i++){
            int u = getMinimumNode(shortestPaths, visitedNodes);
            for(int[] v : adjacencyList.get(u)){
                shortestPaths[v[0]] = Math.min(shortestPaths[u] + v[1], shortestPaths[v[0]]);
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
        int[][] grid = {{0,1,1}, {1,1,0},{1,1,0}};
        MinimumObstacleRemoval_2290 sol = new MinimumObstacleRemoval_2290();
        System.out.println(sol.minimumObstacles(grid));
    }
}
