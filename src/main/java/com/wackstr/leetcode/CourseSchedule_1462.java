package com.wackstr.leetcode;

import java.util.*;

/*
2025-01-27
 */
public class CourseSchedule_1462 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisite, int[][] queries){

        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adjacency.put(i, new ArrayList<>());
        }
        for(int[] prereq: prerequisite){
            adjacency.get(prereq[0]).add(prereq[1]);
        }

        // track a list of parents and update each time the new layer
        int[][] isReachable = new int[numCourses][numCourses];
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0){
                Queue<Integer> nodes = new ArrayDeque<>();
                nodes.add(i);
                Queue<Integer> predecessors = new ArrayDeque<>();
                bfs(nodes, adjacency, predecessors, visited, isReachable);
            }
        }

        List<Boolean> queryAnswer = new ArrayList<>();
        return queryAnswer;
    }

    private void bfs(
            Queue<Integer> nodes,
            Map<Integer, List<Integer>> adjacency,
            Queue<Integer> predecessors,
            int[] visited,
            int[][] isReachable) {

        int n = nodes.size();
        for(int i = 0; i < n; i++) {
            int node = nodes.poll();
            for (int child : adjacency.get(node)) {
                for (int predecessor : predecessors) {
                    isReachable[predecessor][child] = 1;
                }
                isReachable[node][child] = 1;
                if (visited[child] == 0) {
                    nodes.add(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisite = {{1,0}};
        int[][] queries = {{0,1}, {1,0}};
        CourseSchedule_1462 sol = new CourseSchedule_1462();
        System.out.println(sol.checkIfPrerequisite(numCourses, prerequisite, queries));
    }
}
