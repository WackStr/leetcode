package com.wackstr.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
2026-04-13 3296
 */
public class WorkerTime_3296{
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes){
        long res = 0;
        Queue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0] * (a[1] + 1)+a[2]));
        for (int workerTime : workerTimes)
            queue.add(new long[]{workerTime, 0, 0});
        while(mountainHeight > 0){
            long[] worker = queue.poll();
            mountainHeight--;
            worker[1]++;
            worker[2] += worker[1] * worker[0];
            queue.add(worker);
        }
        for (long[] worker : queue)
            res = Math.max(res, worker[2]);
        return res;
    }

    public long minNumberOfSecondsBinary(int mountainHeight, int[] workerTimes) {

        int max = 0;
        for (int x : workerTimes)
            max = Math.max(max, x);

        int h = (mountainHeight-1) / workerTimes.length + 1;
        long left = 1, right = (long) max * h * (h + 1) / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mountainHeight, workerTimes, mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    boolean check(int mountainHeight, int[] workerTimes, long time) {
        for (int x : workerTimes) {
            mountainHeight -= (int)(-1 + Math.sqrt(1 + 8 * time / x)) / 2;
            if (mountainHeight <= 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int mountainHeight = 5;
        int[] workerTimes = {1,7};
        WorkerTime_3296 sol = new WorkerTime_3296();
        System.out.println(sol.minNumberOfSeconds(mountainHeight, workerTimes));
    }
}
