package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
2025-11-06
 */
public class PowerGrids_3607 {

    public static final int SWITCH_OFF = 2;

    private static class Stations {
        private final boolean[] gridOff;
        private final int[] gridParent;
        private final PriorityQueue<Integer>[] gridGroups;

        public Stations(int num){
            gridOff = new boolean[num + 1];
            gridParent = new int[num + 1];
            for (int i = 0; i < gridParent.length; i++)
                gridParent[i] = i;
            gridGroups = new PriorityQueue[num + 1];
        }

        public void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if(pi != pj){
                gridParent[pi] = pj;
            }
        }

        private int find(int station){
            if(station == gridParent[station]) return station;
            int parent = find(gridParent[station]);
            gridParent[station] = parent;
            return parent;
        }

        public int query(int station) {
            if(!gridOff[station]) return station;
            PriorityQueue<Integer> queue = gridGroups[find(station)];
            while(!queue.isEmpty() && gridOff[queue.peek()]) queue.poll();
            return queue.isEmpty() ? -1 : queue.peek();
        }

        public void switchOff(int station){
            gridOff[station] = true;
        }

        public void rankStations() {
            for (int i = 1; i < gridParent.length; i++) {
                int parent = find(i);
                if(gridGroups[parent] == null)
                    gridGroups[parent] = new PriorityQueue<>();
                gridGroups[parent].add(i);
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries){
        ArrayList<Integer> res = new ArrayList<>();
        Stations stations = new Stations(c);
        for (int[] connection : connections)
            stations.union(connection[0], connection[1]);
        stations.rankStations();
        for (int[] query : queries) {
            int op = query[0];
            int station = query[1];
            if (op == SWITCH_OFF) stations.switchOff(station);
            else res.add(stations.query(station));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int c = 3;
        int[][] connections = {{1,2}, {1,3}};
        int[][] queries = {{1,2},{1,3},{2,3},{1,1},{2,3},{1,3},{1,2},{1,2},{2,1},{1,2},{1,1},{1,1},{2,2},{2,3},{1,2},{1,2},{1,1},{2,1},{1,2},{1,3},{1,1},{2,2},{2,3},{2,1},{1,2}};
        PowerGrids_3607 sol = new PowerGrids_3607();
        System.out.println(Arrays.toString(sol.processQueries(
                c,connections, queries
        )));
    }
}
