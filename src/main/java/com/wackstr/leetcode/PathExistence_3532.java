package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-07-09 3532
 */
public class PathExistence_3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // component[i] = connected component containing node i
        int[] component = new int[n];

        int componentId = 0;
        component[0] = componentId;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                componentId++;
            }
            component[i] = componentId;
        }

        boolean[] answer = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            answer[i] = component[u] == component[v];
        }

        return answer;
    }

    private static boolean[] jumpApproach(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;
        int[] nextJump = new int[n];
        int right = 0;
        for (int left = 0; left < n; left++) {
            while(right < n && nums[right] - nums[left] <= maxDiff) right++;
            nextJump[left] = right -1;
        }
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int x = query[0];
            int y = query[1];
            if(x > y){
                int z = x;
                x = y;
                y = z;
            }
            int limit = x;
            do{
                limit = nextJump[limit];
                if(y <= limit){
                    res[i] = true;
                    break;
                }
            }while(limit < nextJump[limit]);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] nums = {2, 5, 6, 8};
        int maxDiff = 2;
        int[][] queries = {{0,1}, {0,2}, {1,3}, {2,3}};
        PathExistence_3532 sol = new PathExistence_3532();
        System.out.println(Arrays.toString(sol.pathExistenceQueries(n,
                nums, maxDiff, queries)));
    }
}
