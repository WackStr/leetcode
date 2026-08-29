package com.wackstr.leetcode;

import java.util.*;

/*
2026-08-29 2948
 */
public class SmallestLexicographicalSwappedArray_2948 {
    private static class DSU {
        private int[] parents;
        private int[] sizes;
        private Map<Integer, Queue<Integer>> heap;
        public DSU(int[] res) {
            parents = new int[res.length];
            sizes = new int[res.length];
            heap = new HashMap<>();
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            Arrays.fill(sizes, 1);
        }

        public int find(int x){
            if(parents[x] == x) return x;
            int parent = find(parents[x]);
            parents[x] = parent;
            return parent;
        }

        public void join(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            if(parentX != parentY){
                if(sizes[parentX] < sizes[parentY]){
                    int z = parentX;
                    parentX = parentY;
                    parentY = z;
                }
                parents[parentY] = parentX;
                sizes[parentX] += sizes[parentY];
            }
        }

        public void addNumber(int i, int num) {
            if(!heap.containsKey(i)) heap.put(i, new PriorityQueue<>());
            heap.get(i).add(num);
        }

        public int getNext(int i) {
            return heap.get(i).poll();
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) numsSorted[i] = nums[i];
        Arrays.sort(numsSorted);

        int currGroup = 0;
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(
                currGroup,
                new LinkedList<Integer>(Arrays.asList(numsSorted[0]))
        );

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                // new group
                currGroup++;
            }

            // assign current element to group
            numToGroup.put(numsSorted[i], currGroup);

            // add element to sorted group list
            if (!groupToList.containsKey(currGroup)) {
                groupToList.put(currGroup, new LinkedList<Integer>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }

        // iterate through input and overwrite each element with the next element in its corresponding group
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }

        return nums;
    }

    private static int[] dsuSolution(int[] nums, int limit) {
        int n = nums.length;
        int[] res = Arrays.copyOf(nums, n);
        Map<Integer, Queue<Integer>> lookup = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!lookup.containsKey(nums[i])) lookup.put(nums[i], new LinkedList<>());
            lookup.get(nums[i]).add(i);
        }
        Arrays.sort(res);
        int[] indexes = new int[n];
        for (int i = 0; i < res.length; i++) indexes[i] = lookup.get(res[i]).poll();
        DSU groups = new DSU(res);
        for (int i = 1; i < res.length; i++) {
            if(Math.abs(res[i] - res[i-1]) <= limit) groups.join(indexes[i-1], indexes[i]);
        }
        for (int i = 0; i < n; i++) {
            groups.addNumber(groups.find(i), nums[i]);
        }
        for (int i = 0; i < n; i++) {
            res[i] = groups.getNext(groups.find(i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,6,18,2,1};
        int limit = 3;
        SmallestLexicographicalSwappedArray_2948 sol = new SmallestLexicographicalSwappedArray_2948();
        System.out.println(Arrays.toString(sol.lexicographicallySmallestArray(nums, limit)));
    }
}
