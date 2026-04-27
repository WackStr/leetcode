package com.wackstr.leetcode;

/*
2026-04-27 1391
 */
public class GridValidPath_1391 {
    /*
    1 left cell and the right cell.
    2 upper cell and the lower cell.
    3 left cell and the lower cell.
    4 right cell and the lower cell.
    5 left cell and the upper cell.
    6 right cell and the upper cell.
     */
    private static class DSU {

        private final int[] parents;
        private final int[] size;

        public DSU(int n) {
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public void join(int x, int y) {
            if(size[x] > size[y]){
                int temp = y;
                y = x;
                x = temp;
            }
            parents[find(x)] = find(y);
            size[y] += size[x];
        }

        public int find(int x) {
            if(parents[x] == x) return x;
            int currParent = find(parents[x]);
            parents[x] = currParent;
            return currParent;
        }
    }
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DSU unionSet = new DSU(grid.length * grid[0].length);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int currDir = grid[i][j];
                if(i > 0){
                    int lastDir = grid[i-1][j];
                    if((currDir == 2 || currDir == 5 || currDir == 6)&&(lastDir == 2 || lastDir == 3 || lastDir == 4)){
                        unionSet.join(i * n + j, (i-1) * n + j);
                    }
                }
                if(j > 0){
                    int lastDir = grid[i][j-1];
                    if((currDir == 1 || currDir == 3 || currDir == 5) && (lastDir == 1 || lastDir == 4 || lastDir == 6)){
                        unionSet.join(i* n + j, i*n + j-1);
                    }
                }
            }
        }
        return unionSet.find(0) == unionSet.find(m * n - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{2,4,3},{6,5,2}};
        GridValidPath_1391 sol = new GridValidPath_1391();
        System.out.println(sol.hasValidPath(grid));
    }
}
