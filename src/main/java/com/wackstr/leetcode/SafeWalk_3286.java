package com.wackstr.leetcode;

import java.util.*;

/*
2026-07-02 3286
 */
public class SafeWalk_3286 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    // 0-1 BFS with pruning
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerFirst(new int[] { 0, 0 });
        dis[0][0] = grid.get(0).get(0);

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int cx = cur[0];
            int cy = cur[1];
            // the first time it leaves the queue, the shortest distance is guaranteed
            if (cx == m - 1 && cy == n - 1) {
                return true;
            }

            for (int[] dir : DIRECTIONS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                int cost = dis[cx][cy] + grid.get(nx).get(ny);
                // pruning: the new distance does not meet health requirements
                if (cost >= health) {
                    continue;
                }
                if (cost < dis[nx][ny]) {
                    dis[nx][ny] = cost;
                    if (grid.get(nx).get(ny) == 0) {
                        q.offerFirst(new int[] { nx, ny });
                    } else {
                        q.offerLast(new int[] { nx, ny });
                    }
                }
            }
        }
        return false;
    }

    private static boolean djikstra(List<List<Integer>> grid, int health) {
        int minCost;
        int n = grid.size();
        int m = grid.get(0).size();
        PriorityQueue<int[]> nodes =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        nodes.offer(new int[]{grid.get(0).get(0),0,0});

        while(!nodes.isEmpty()){
            int[] node = nodes.poll();
            int d  = node[0];
            int x = node[1];
            int y = node[2];

            if(d < dist[x][y]) {


                dist[x][y] = d;
                for (int[] dir : DIRECTIONS) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                        int candidateDistance = d + grid.get(newX).get(newY);

                        if(candidateDistance < dist[newX][newY]) {
                            nodes.offer(new int[]{candidateDistance, newX, newY});
                        }
                    }
                }
            }
        }
        minCost = dist[n-1][m-1];
        return health > minCost;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,0,0,0},
                {1,0,1,0,0,0},
                {0,1,1,1,0,1},
                {0,0,1,0,1,0}};
        int health = 3;
        List<List<Integer>> grid = new ArrayList<>();
        for (int[] row : matrix) {
            grid.add(Arrays.stream(row).boxed().toList());
        }
        SafeWalk_3286 sol = new SafeWalk_3286();
        System.out.println(sol.findSafeWalk(grid, health));
    }
}
