package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindChampion_2924 {
    public int findChampion(int n, int[][] edges){
        if(n == 1) return 0;
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        Set<Integer> nodesExplored = new HashSet<>();
        for(int[] edge : edges) {
            int root = edge[0];
            int target = edge[1];
            adjacencyList.computeIfAbsent(root, k -> new HashSet<>()).add(target);
            nodesExplored.add(root);
            nodesExplored.add(target);
        }
        if(nodesExplored.size() < n) return -1;
        Set<Integer> candidateNodes =
                getTopCandidates(adjacencyList);
        if(candidateNodes.size() == 1){
            return candidateNodes.stream().findAny().get();
        }else{
            return -1;
        }
    }

    private Set<Integer> getTopCandidates(Map<Integer, Set<Integer>> adjacencyList) {
        Set<Integer> optimal = new HashSet<>();
        Set<Integer> subOptimal = new HashSet<>();
        adjacencyList.forEach((node, subNodes) -> {
            if (!subOptimal.contains(node)) {
                optimal.add(node);
            }
            for (Integer targetNode : subNodes) {
                subOptimal.add(targetNode);
                optimal.remove(targetNode);
            }
        });
        return optimal;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1}, {1,2}};
        FindChampion_2924 sol = new FindChampion_2924();
        System.out.println((sol.findChampion(n, edges)));
    }
}
