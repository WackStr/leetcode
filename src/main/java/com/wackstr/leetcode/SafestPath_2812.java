package com.wackstr.leetcode;

import java.util.*;

/*
2026-07-01 2182
 */
public class SafestPath_2812 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) return 0;
        int[][] safety = calculateSafety(grid);
        return binarySearch(grid, safety);
    }

    private int binarySearch(List<List<Integer>> grid, int[][] safety) {
        int n = grid.size();
        int left = 0;
        int right = n-1;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(canTraverse(grid, safety, mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private int[][] calculateSafety(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] safety = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    queue.add(i*n + j);
                    visited[i][j] = true;
                }
            }
        }
        int currDistance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0) {
                int curr = queue.poll();
                int x = curr / n;
                int y = curr % n;
                for (int[] dir : DIRECTIONS) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < n){
                        if(!visited[newX][newY] && grid.get(newX).get(newY) != 1){
                            safety[newX][newY] = safety[newX][newY] == 0 ? currDistance : Math.min(currDistance, safety[newX][newY]);
                            visited[newX][newY] = true;
                            queue.add(newX * n + newY);
                        }
                    }
                }
                size--;
            }
            currDistance++;
        }
        return safety;
    }

    private boolean canTraverse(List<List<Integer>> grid, int[][] safety, int target) {
        if(safety[0][0] < target) return false;
        int n = grid.size();
        int dest = n * n -1;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0) {
                int curr = queue.poll();
                if(curr == dest) return true;
                int x = curr / n;
                int y = curr % n;
                for (int[] dir : DIRECTIONS) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < n){
                        if(!visited[newX][newY] && safety[newX][newY] >= target){
                            visited[newX][newY] = true;
                            queue.add(newX * n + newY);
                        }
                    }
                }
                size--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] gridMatrix = {{0,0,0,1}, {0,0,0,0}, {0,0,0,0}, {1,0,0,0}};
        List<List<Integer>> grid = getGrid(gridMatrix);
        SafestPath_2812 sol = new SafestPath_2812();
        System.out.println(sol.maximumSafenessFactor(grid));
    }

    private static List<List<Integer>> getGrid(int[][] gridMatrix) {
        List<List<Integer>> grid = new ArrayList<>();
        for (int[] row : gridMatrix) {
            grid.add(Arrays.stream(row).boxed().toList());
        }
        return grid;
    }
}
