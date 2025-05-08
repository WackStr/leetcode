package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumTime_3342 {
    private static final int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(dist, o.dist);
        }
    }

    public int minTimeToReach(int[][] moveTime){
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] distances = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Node> stack = new PriorityQueue<>();

        for(int[] row : distances){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distances[0][0] = 0;
        stack.offer(new Node(0,0, 0));
        while(!stack.isEmpty()){
            Node curr = stack.poll();
            if(!visited[curr.x][curr.y]){
                visited[curr.x][curr.y] = true;
                for(int[] dir : deltas){
                    int nx = curr.x + dir[0];
                    int ny = curr.y + dir[1];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                        int dist = Math.max(distances[curr.x][curr.y], moveTime[nx][ny]) + (curr.x + curr.y) % 2 + 1;
                        if(dist < distances[nx][ny]){
                            distances[nx][ny] = dist;
                            stack.offer(new Node(nx, ny, dist));
                        }
                    }
                }
            }
        }
        return distances[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] moveTime = {{0,4}, {4,4}};
        MinimumTime_3342 sol = new MinimumTime_3342();
        System.out.println(sol.minTimeToReach(moveTime));
    }
}
