package com.wackstr.leetcode;


import java.util.*;

/*
2025-01-24
 */
public class EventualSafeStates_802 {
    public List<Integer> eventualSafeNodes(int[][] graph){
        List<Integer> safeStates = new ArrayList<>();
        int n = graph.length;
        int[] memo = new int[n];


        for(int i = 0; i < n; i++){
            if(isSafe(i, graph, memo, new HashSet<>())){
                safeStates.add(i);
            }

        }
        return safeStates;
    }

    private boolean isSafe(int i, int[][] graph, int[] memo, Set<Integer> visited) {
        if(graph[i].length == 0) {
            return true;
        }

        if(memo[i] == 0){
            boolean safe = true;
            visited.add(i);
            for(int node : graph[i]){
                if(visited.contains(node)) {
                    safe = false;
                    break;
                }
                safe = safe & isSafe(node, graph, memo, visited);
                if(!safe) break;
            }
            memo[i] = safe ? 1 : -1;
            visited.remove(i);
            return safe;
        }else{
            return memo[i] == 1;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2,4}, {0, 2, 3, 4}, {3}, {4}, {}};
        // [[1,2],[2,3],[5],[0],[5],[],[]]
        //[[2,3],[2,3,4],[3,4],[],[1]]
        graph = new int[][]{{}, {0,2,3,4}, {3}, {4}, {}};
        EventualSafeStates_802 sol = new EventualSafeStates_802();
        System.out.println(sol.eventualSafeNodes(graph));
    }
}
