package com.wackstr.leetcode;

import java.util.*;

/*
2024-11-30
 */
public class ValidPairSequence_2097 {

    public int[][] validArrangement(int[][] pairs){
        Map<Integer, Deque<Integer>> forwardGraph = new HashMap<>();
        Map<Integer, Deque<Integer>> reverseGraph = new HashMap<>();
        // populate the two graphs
        for(int[] pair : pairs){
            forwardGraph.computeIfAbsent(pair[0], k -> new ArrayDeque<>()).add(pair[1]);
            forwardGraph.computeIfAbsent(pair[1], k -> new ArrayDeque<>());
            reverseGraph.computeIfAbsent(pair[1], k -> new ArrayDeque<>()).add(pair[0]);
            reverseGraph.computeIfAbsent(pair[0], k -> new ArrayDeque<>());
        }
        Deque<int[]> finalSequence = new ArrayDeque<>();
        int n = 0;
        // build the final sequence
        while(n < pairs.length)
        {
            if(finalSequence.isEmpty()){
                int[] currEdge = pairs[0];
                finalSequence.add(currEdge);
                forwardGraph.get(currEdge[0]).remove(currEdge[1]);
                reverseGraph.get(currEdge[1]).remove(currEdge[0]);
                n++;
            } else {
                int leftNode = finalSequence.peekFirst()[0];
                int rightNode = finalSequence.peekLast()[1];

                if(!reverseGraph.get(leftNode).isEmpty()) {
                    int leftEdgeStart = reverseGraph.get(leftNode).pollFirst();
                    finalSequence.push(new int[]{leftEdgeStart, leftNode});
                    forwardGraph.get(leftEdgeStart).remove(leftNode);
                    reverseGraph.get(leftNode).remove(leftEdgeStart);
                    n++;
                }else if(!reverseGraph.get(finalSequence.peekFirst()[1]).isEmpty()){
                    // cannot push on left
                    int[] edge = finalSequence.pollFirst();
                    forwardGraph.get(edge[0]).add(edge[1]);
                    reverseGraph.get(edge[1]).add(edge[0]);
                    n--;
                }

                if(!forwardGraph.get(rightNode).isEmpty()) {
                    int rightEdgeEnd = forwardGraph.get(rightNode).pollFirst();
                    finalSequence.add(new int[]{rightNode, rightEdgeEnd});
                    forwardGraph.get(rightNode).remove(rightEdgeEnd);
                    reverseGraph.get(rightEdgeEnd).remove(rightNode);
                    n++;
                }else if(!forwardGraph.get(finalSequence.peekLast()[0]).isEmpty()){
                    // cannot push on right
                    // only revert if there were multiple edges
                    int[] edge = finalSequence.pollLast();
                    forwardGraph.get(edge[0]).add(edge[1]);
                    reverseGraph.get(edge[1]).add(edge[0]);
                    n--;
                }
            }
        }
        return finalSequence.toArray(new int[finalSequence.size()][2]);
    }

    public static void main(String[] args) {
        int[][] pairs = {{5,1}, {4,5}, {11,9},{9,4}};
         pairs = new int[][]{{1,3}, {3,2},{2,1}};
        pairs = new int[][]{{1,2}, {1,3}, {2,1}};
        ValidPairSequence_2097 sol = new ValidPairSequence_2097();
        System.out.println(Arrays.deepToString(sol.validArrangement(pairs)));
    }
}
