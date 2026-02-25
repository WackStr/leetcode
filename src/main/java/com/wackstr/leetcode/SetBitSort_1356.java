package com.wackstr.leetcode;

import java.util.PriorityQueue;

/*
    2026-02-25 1356
*/
public class SetBitSort_1356 {
        public int[] sortByBits(int[] arr) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> {
                        if (a[0] != b[0]) return a[0] - b[0];
                        return a[1] - b[1];
                    }
            );

            for(int i=0;i<arr.length;i++){
                int num = count_bits(arr[i]);
                pq.offer(new int[]{num, arr[i]});
            }

            int index = 0;
            while (!pq.isEmpty()) {
                arr[index++] = pq.poll()[1];
            }

            return arr;
        }

        public int count_bits(int n){
            int ans = 0;
            while(n>0){
                ans++;
                n = (n&(n-1));
            }
            return ans;
        }
}
