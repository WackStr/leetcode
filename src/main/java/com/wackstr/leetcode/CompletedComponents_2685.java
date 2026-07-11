package com.wackstr.leetcode;

/*
2026-07-11 2685
 */
public class CompletedComponents_2685 {
    private static class DSU {
        // tracks representative parent for each component
        private final int[] parents;
        /*
         tracks number of edges in the component and size of the component
         is meaningful if the index itself is a parent
         */
        private final int[] edges;
        private final int[] sizes;

        public DSU(int n){

            // initialization of all the arrays
            parents = new int[n];
            edges =  new int[n];
            sizes = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int getCompletedComponents(){
            int res = 0;
            for (int i = 0; i < parents.length; i++) {
                /*
                if the current index is itself a parent it represents a group
                a completed group of size k will have k(k-1)/2 edges
                this is the number of unique pairs possible
                if this is the case increment the count
                 */
                if (parents[i] == i && edges[i] == (sizes[i] * (sizes[i]-1))/2)
                    res++;
            }
            return res;
        }

        // only exposing this to maintain abstraction of joining edges
        public void join(int[] edge) {
            join(edge[0], edge[1]);
        }

        private void join(int x, int y){
            int px = find(x);
            int py = find(y);

            /*
            Join if not the same component else only increment edge count
             */
            if(px != py) {

                /*
                joining smaller group to larger so find path compression
                is optimized
                 */
                if (sizes[px] < sizes[py]) {
                    int pz = py;
                    py = px;
                    px = pz;
                }
                parents[py] = px;
                // add size of smaller group to larger
                sizes[px] += sizes[py];
                /*
                the joined group inherits the edges of new group + 1 for the
                edge joining these two components
                 */
                edges[px] += edges[py] + 1;
            }else{
                // if same component, only edge count increases by 1
                edges[px]++;
            }
        }

        private int find(int x){
            if(parents[x] == x) return x;
            /*
             path compression to make future finds performant
             and reducing amortized time to linear for find
             */
            int parent = find(parents[x]);
            parents[x] = parent;
            return parent;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        /*
        With the DSU defined as above, the solution becomes simple.
        Define the DSU, join on all the edges and run its method to count
        the completed components.
         */
        DSU group = new DSU(n);
        for (int[] edge : edges) {
            group.join(edge);
        }
        return group.getCompletedComponents();
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1}, {0,2}, {1,2}, {3,4}, {3,5}};
        CompletedComponents_2685 sol = new CompletedComponents_2685();
        System.out.println(sol.countCompleteComponents(n, edges));
    }
}
