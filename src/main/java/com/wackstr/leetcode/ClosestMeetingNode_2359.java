package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-05-30
 */
public class ClosestMeetingNode_2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2){
        int[] dist1 = dfs(edges, node1);
        int[] dist2 = dfs(edges, node2);
        int minDistance = edges.length;
        int minNode = -1;
        for(int i = 0; i < edges.length; i++){
            if(dist1[i] != -1 && dist2[i] != -1){
                int dist = Math.max(dist1[i], dist2[i]);
                if(dist < minDistance) {
                    minNode = i;
                    minDistance = dist;
                }
            }
        }
        return minNode;
    }

    private int[] dfs(int[] edges, int node1) {
        int[] distances = new int[edges.length];
        boolean[] seen = new boolean[edges.length];
        Arrays.fill(distances, -1);
        int dist = 0;
        int currNode = node1;
        distances[currNode] = dist;
        seen[currNode] = true;
        while(edges[currNode] != -1 && !seen[edges[currNode]]){
            dist++;
            currNode = edges[currNode];
            distances[currNode] = dist;
            seen[currNode] = true;
        }
        return distances;
    }

    public static void main(String[] args) {
        int[] edges = {4,4,4,5,1,2,2};
        int node1 = 1;
        int node2 = 1;
        ClosestMeetingNode_2359 sol = new ClosestMeetingNode_2359();
        System.out.println(sol.closestMeetingNode(edges, node1, node2));
    }
}
