package com.wackstr.leetcode;

import java.util.*;

/*
2026-07-03 3620
 */
public class NetworkRecoveryPathway_3620 {
//    private int tabs = 0;

    private int[] head, next, to, weight;
    private long k;
    private int n;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.n = online.length;
        this.k = k;

        int m = edges.length;
        this.head = new int[n];
        this.next = new int[m];
        this.to = new int[m];
        this.weight = new int[m];
        Arrays.fill(head, -1);
        int left = Integer.MAX_VALUE, right = 0;
        for(int i = 0; i < m; i++) {
            int a = edges[i][0], b = edges[i][1], c = edges[i][2];
            if(online[a] && online[b]) {
                to[i] = b;
                next[i] = head[a];
                weight[i] = c;
                head[a] = i;

                if(c > right) right = c;
                if(c < left) left = c;
            }
        }

        if(!check(0)) return -1;

        while(left < right) {
            int mid = left + right + 1 >>> 1;
            if(check(mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private static final int[] queue = new int[50001];
    private boolean check(int threshold) {
        long[] dist = new long[n];
        Arrays.fill(dist, k + 1);
        dist[0] = 0;

        int read = 0, write = 1;
        while(read < write) {
            int current = queue[read++];
            //if(current.dist > dist[current.index]) continue;
            for(int i = head[current]; i != -1; i = next[i]) {
                if(weight[i] < threshold) continue;
                int nextIndex = to[i];
                long d = dist[current] + weight[i];
                if(d < dist[nextIndex]) {
                    if(nextIndex == n - 1) return true;
                    dist[nextIndex] = d;
                    queue[write++] = nextIndex;
                }
            }
        }
        return false;
    }
    private static final class Node {
        private final int index;
        private final long dist;
        private Node(int index, long dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    private int originalApproach(int[][] edges, boolean[] online, long k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges)
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        Map<Integer, Integer> currNodes = new HashMap<>();
        return dfs(-1, 0, 0,
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1])),
                currNodes,
                adj,
                online,
                k);
    }

    private int dfs(
            int max,
            int currCost,
            int node,
            PriorityQueue<int[]> nodeCosts,
            Map<Integer, Integer> activeNodes,
            Map<Integer, List<int[]>> adj,
            boolean[] online,
            long k) {
//        StringBuilder log = new StringBuilder();
//        int tabCount = tabs;
//        while(tabCount > 0){
//            log.append("  ");
//            tabCount--;
//        }
//        log.append("dfs(max = ").append(max).append(", currCost = ").append(currCost).append(", node = ").append(node).append(")");
//        System.out.println(log);
        if(currCost > k) {
//            log = new StringBuilder();
//            tabCount = tabs;
//            while(tabCount > 0){
//                log.append("  ");
//                tabCount--;
//            }
//            log.append("  Exiting since currCost > k");
//            System.out.println(log);
            return max;
        }
        if(node == online.length - 1) {
            while(!nodeCosts.isEmpty()){
                int[] candidate = nodeCosts.peek();
                if(activeNodes.containsKey(candidate[0]) && activeNodes.get(candidate[0]) == candidate[1]) break;
                nodeCosts.poll();
            }
//            int res = nodeCosts.peek()[1];
//            log = new StringBuilder();
//            tabCount = tabs;
//            while(tabCount > 0){
//                log.append("  ");
//                tabCount--;
//            }
//            log.append("  Reached End. Returning ").append(res);
//            System.out.println(log);
            return nodeCosts.peek()[1];
        }


        int cost = max;
        if(adj.containsKey(node)){
            for (int[] neighbor : adj.get(node)) {
                int neighborNode = neighbor[0];
                int neighborCost = neighbor[1];
                if(online[neighborNode]){
                    activeNodes.put(neighborNode, neighborCost);
                    nodeCosts.add(neighbor);
//                    tabs++;
                    cost = Math.max(cost, dfs(max, currCost + neighborCost, neighborNode, nodeCosts, activeNodes, adj, online, k));
//                    tabs--;
                    activeNodes.remove(neighborNode);
                }
            }
        }
//        log = new StringBuilder();
//        tabCount = tabs;
//        while(tabCount > 0){
//            log.append("  ");
//            tabCount--;
//        }
//        log.append("returning ").append(cost).append(" after evaluating all neighbors");
//        System.out.println(log);
        return cost;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,7},{1,4,5},{0,2,6},{2,3,6},{3,4,2},{2,4,6}};
        boolean[] online = {true,true,true,false,true};
        int k = 12;
        NetworkRecoveryPathway_3620 sol = new NetworkRecoveryPathway_3620();
        System.out.println(sol.findMaxPathScore(edges, online, k));
    }
}
