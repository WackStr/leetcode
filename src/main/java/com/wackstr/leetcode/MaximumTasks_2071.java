package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumTasks_2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int low = 0, high = Math.min(tasks.length, workers.length);

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int taskCount) {
        Deque<Integer> boosted = new ArrayDeque<>();
        int w = workers.length - 1;
        int freePills = pills;

        for (int t = taskCount - 1; t >= 0; t--) {
            int task = tasks[t];

            if (!boosted.isEmpty() && boosted.peekFirst() >= task) {
                boosted.pollFirst();
            } else if (w >= 0 && workers[w] >= task) {
                w--;
            } else {
                while (w >= 0 && workers[w] + strength >= task) {
                    boosted.addLast(workers[w--]);
                }
                if (boosted.isEmpty() || freePills == 0) {
                    return false;
                }
                boosted.pollLast();
                freePills--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] tasks = {3,2,1};
        int[] workers ={0, 3, 3};
        int pills = 1;
        int strength = 1;
        MaximumTasks_2071  sol = new MaximumTasks_2071();
        System.out.println(sol.maxTaskAssign(
                tasks,
                workers,
                pills,
                strength
        ));
    }
}
