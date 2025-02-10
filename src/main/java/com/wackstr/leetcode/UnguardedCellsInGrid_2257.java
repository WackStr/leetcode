package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
2024-11-21
 */
public class UnguardedCellsInGrid_2257 {

    public int countUnguarded(
            int m, int n, int[][] guards, int[][] walls) {
        Map<Integer, Set<Integer>> cells = getCellCollection(m, n);
        Map<Integer, Set<Integer>> guardsLookup = mapToLookup(guards);
        Map<Integer, Set<Integer>> wallsLookup = mapToLookup(walls);
        for(int[] guard : guards) {
            removeCells(m, n, guard, guardsLookup, wallsLookup, cells);
        }
        removeFromCollection(cells, guardsLookup);
        removeFromCollection(cells, wallsLookup);
        return countTotalCells(cells);
    }

    private void removeCells(
            int m,
            int n,
            int[] guard,
            Map<Integer, Set<Integer>> guardsLookup,
            Map<Integer, Set<Integer>> wallsLookup,
            Map<Integer, Set<Integer>> cells) {
        int guardRow = guard[0];
        int guardCol = guard[1];
        // go left
        for (int col = guardCol - 1; col >= 0; col--) {
            if(process(guardRow, col, guardsLookup, wallsLookup, cells)){
                break;
            }
        }
        // go right
        for (int col = guardCol + 1; col < n; col++) {
            if(process(guardRow, col, guardsLookup, wallsLookup, cells)){
                break;
            }
        }
        // go up
        for(int row = guardRow - 1; row >= 0; row--){
            if(process(row, guardCol, guardsLookup, wallsLookup, cells)){
                break;
            }
        }
        // go down
        for(int row = guardRow + 1; row < m; row++){
            if(process(row, guardCol, guardsLookup, wallsLookup, cells)){
                break;
            }
        }
    }

    private boolean process(int row, int col,
                    Map<Integer, Set<Integer>> guardsLookup,
                    Map<Integer, Set<Integer>> wallsLookup,
                    Map<Integer, Set<Integer>> cells){
        if(containsCell(row, col, guardsLookup) ||
                containsCell(row, col, wallsLookup)){
            return true;
        }else{
            removeFromCollection(cells, row, col);
            return false;
        }
    }


    private boolean containsCell(
            int row,
            int col,
            Map<Integer, Set<Integer>> lookup) {
        return lookup.containsKey(row)
                && lookup.get(row).contains(col);
    }

    private void removeFromCollection(
            Map<Integer, Set<Integer>> cells,
            int row, int col) {
        if(cells.containsKey(row)){
            cells.get(row).remove(col);
        }
    }

    private int countTotalCells(Map<Integer, Set<Integer>> cells) {
        int cnt = 0;
        for(Set<Integer> cols : cells.values()){
            cnt += cols.size();
        }
        return cnt;
    }

    private void removeFromCollection(
            Map<Integer, Set<Integer>> cells,
            Map<Integer, Set<Integer>> lookup) {
        for(int row : lookup.keySet()){
            if(cells.containsKey(row)){
                for(int col : lookup.get(row)){
                    removeFromCollection(cells, row, col);
                }
            }
        }
    }

    private Map<Integer, Set<Integer>> mapToLookup(int[][] cells) {
        Map<Integer, Set<Integer>> lookup = new HashMap<>();
        for(int[] cell : cells){
            int row = cell[0];
            int col = cell[1];
            lookup.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }
        return lookup;
    }

    public Map<Integer, Set<Integer>> getCellCollection(int rows, int cols){
        Map<Integer, Set<Integer>> cells = new HashMap<>();
        for(int i = 0; i < rows; i++){
            cells.put(i, new HashSet<>());
            for(int j = 0; j < cols; j++){
                cells.get(i).add(j);
            }
        }
        return cells;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = {{0,0}, {1,1}, {2,3}};
        int[][] walls = {{0,1}, {2,2},{1,4}};
        UnguardedCellsInGrid_2257 sol = new UnguardedCellsInGrid_2257();
        System.out.println(sol.countUnguarded(m, n, guards, walls));
    }
}
