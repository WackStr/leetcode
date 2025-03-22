package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/*
2025-03-22
 */
public class CompleteComponents_2685 {
    private static class DisjointSetUnion{

        /*
           Tracks the parent of each node. if parent of a node is the same as
           the node then that node is the representative of a group/set
         */
        private final int[] parents;
        // this helps merge smaller sets into larger sets
        private final int[] sizes;
        // tracks representatives as a separate set
        private final HashSet<Integer> clusters;
        // the total edges in each set
        private final int[] edges;

        /**
         * A class that represent union of different nodes to form disjoint sets
         * The total size of nodes is defined at initialization
         * This class supports basic operations of find and union
         * Can also give count of completely conneted components
         * @param n the total number of nodes possible (0 - indexed)
         */
        public DisjointSetUnion(int n){
            parents = new int[n];
            sizes = new int[n];
            clusters = new HashSet<>();
            edges = new int[n];
            for(int i = 0; i < parents.length; i++){
                parents[i] = i;
                clusters.add(i);
            }
            Arrays.fill(sizes, 1);
        }

        /**
         * Find the parent of the given node
         * Applies path compression in each find to eventually make find a
         * constant time operation
         * @param node the node to find the parent for
         * @return the parent node (self if it is representative)
         */
        public int find(int node){
            if(parents[node] == node) return node;
            else {
                // apply path compression
                int parent = find(parents[node]);
                parents[node] = parent;
                return parent;
            }
        }

        /**
         * Joins the group/sets represented by two nodes. merges the smaller
         * group into the larger one. Also updates the size and count of edges
         * in the group and the groups available
         * @param u node representative of group
         * @param v node representative of group
         */
        public void union(int u, int v){
            int parentU = find(u);
            int parentV = find(v);
            /*
             merge the smaller group into larger
             by updating parent
             also add the sizes and edges.
             Add one to the sum of edges to represent the new
             joining edge
             */
            if(parentU != parentV){
                if(sizes[parentU] > sizes[parentV]){
                    parents[parentV] = parentU;
                    sizes[parentU] += sizes[parentV];
                    clusters.remove(parentV);
                    edges[parentU] += edges[parentV] + 1;
                }else{
                    parents[parentU] = parentV;
                    sizes[parentV] += sizes[parentU];
                    clusters.remove(parentU);
                    edges[parentV] += edges[parentU] + 1;
                }
            }else {
            /*
            if nodes are in the same group, increase the number of edges in it.
            This assumes that all edges in union are unique
             */
                edges[parentU]++;
            }
        }

        /**
         * Returns count of groups where every pair is connected
         * This assumes that during union only unique edges were applied.
         * A set of size k will be complete if it has k(k-1)/2 unique edges
         * Then each node will be connected to every other node in the set
         * @return number of complete components in the class
         */
        private int getCompleteComponentCount() {
            int cnt = 0;
            for(int node : clusters){
                if(sizes[node]*(sizes[node]-1)/2 == edges[node]){
                    cnt++;
                }
            }
            return cnt;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        // create a dsu, define union using the edges and count complete sets
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        for(int[] edge : edges){
            dsu.union(edge[0], edge[1]);
        }
        return dsu.getCompleteComponentCount();
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,2}, {3,4}, {1,4},{2,3}, {1,3}, {2, 4}};
        // expected = 2;
        CompleteComponents_2685 sol = new CompleteComponents_2685();
        System.out.println(sol.countCompleteComponents(n, edges));
    }
}
