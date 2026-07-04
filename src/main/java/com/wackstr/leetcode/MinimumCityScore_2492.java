package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-07-04 2492
 */
public class MinimumCityScore_2492 {
    private static class DSU {
        private final int[] parents;
        private final int[] sizes;
        private final int[] minPath;

        public DSU(int n){
            parents = new int[n+1];
            sizes = new int[n+1];
            minPath = new int[n+1];

            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            Arrays.fill(sizes,1);
            Arrays.fill(minPath, Integer.MAX_VALUE);
        }

        public int find(int x){
            if(parents[x] == x){
                return x;
            }
            // path compression
            int parent = find(parents[x]);
            parents[x] = parent;
            return parent;
        }

        public void join(int x, int y, int d){
            int px = find(x);
            int py = find(y);
            if(px != py){
                // merge the smaller group into larger
                if(sizes[px] < sizes[py]){
                    int z = px;
                    px = py;
                    py = z;
                }
                parents[py] = parents[px];
                sizes[px] += sizes[py];
            }
            minPath[px] = Math.min(Math.min(minPath[px], minPath[py]), d);
        }

        public int getMin(int x){
            return minPath[find(x)];
        }
    }
    public int minScore(int n, int[][] roads){
        DSU dsu = new DSU(n);
        for (int[] road : roads) {
            dsu.join(road[0], road[1], road[2]);
        }
        return dsu.getMin(1);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] roads = {{4,5,7468},{6,2,7173},{6,3,8365},{2,3,7674},{5,6,7852},{1,2,8547},{2,4,1885},{2,5,5192},{1,3,4065},{1,4,7357}};
        MinimumCityScore_2492 sol = new MinimumCityScore_2492();
        System.out.println(sol.minScore(n, roads));
    }
}
