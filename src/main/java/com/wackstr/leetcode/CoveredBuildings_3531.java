package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
2025-12-11 3531
 */
public class CoveredBuildings_3531 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];

        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);

        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            maxRow[y] = Math.max(maxRow[y], x);
            minRow[y] = Math.min(minRow[y], x);
            maxCol[x] = Math.max(maxCol[x], y);
            minCol[x] = Math.min(minCol[x], y);
        }

        int res = 0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            if (
                    x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]
            ) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] buildings = {{1,2}, {2,2}, {3,2}, {2,1}, {2,3}};
        CoveredBuildings_3531 sol = new CoveredBuildings_3531();
        System.out.println(sol.countCoveredBuildings(n, buildings));
    }
}
