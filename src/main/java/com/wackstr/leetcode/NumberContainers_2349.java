package com.wackstr.leetcode;

import java.util.*;

/*
2025-02-08
 */
public class NumberContainers_2349 {

    private final Map<Integer, TreeSet<Integer>> numIndexes;
    private final Map<Integer, Integer> indexFind;

    public NumberContainers_2349() {
        numIndexes = new HashMap<>();
        indexFind = new HashMap<>();
    }

    public void change(int index, int number) {
        if(indexFind.containsKey(index)){
            int numToRemoveIndexFrom = indexFind.get(index);
            Set<Integer> indexes = numIndexes.get(numToRemoveIndexFrom);
            indexes.remove(index);
        }
        TreeSet<Integer> indexes =
                numIndexes.computeIfAbsent(number, k -> new TreeSet<>());
            indexes.add(index);
        indexFind.put(index, number);

    }

    public int find(int number) {
        if(!numIndexes.containsKey(number) || numIndexes.get(number).isEmpty()) return -1;
        TreeSet<Integer> indexes = numIndexes.get(number);
        return indexes.first();
    }

    public static void main(String[] args) {
        NumberContainers_2349 cont = new NumberContainers_2349();
        System.out.println(cont.find(10));
        cont.change(2, 10);
        cont.change(1, 10);
        cont.change(3, 10);
        cont.change(5, 10);
        System.out.println(cont.find(10));
        cont.change(1, 20);
        System.out.println(cont.find(10));
    }
}
