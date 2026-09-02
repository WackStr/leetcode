package com.wackstr.leetcode.learn.queue.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private static final int[][] DIRECTIONS = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < res.length; i++) {
            res[i] = Arrays.copyOf(image[i], n);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        res[sr][sc] = color;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx >= 0 && nx < m &&
                ny >= 0 && ny < n &&
                res[nx][ny] == image[sr][sc]){
                    queue.add(new int[]{nx, ny});
                    res[nx][ny] = color;
                }
            }
        }
        return res;
    }
}
