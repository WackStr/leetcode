package com.wackstr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
2025-06-03
 */
public class Candies_1298 {
    public int maxCandies(
            int[] status,
            int[] candies,
            int[][] keys,
            int[][] containedBoxes,
            int[] initialBoxes
    ) {
        int n = status.length;

        // haveKey[b] == true  means “we have the key for box b”
        boolean[] haveKey = new boolean[n];
        // inQueue[b] == true means “box b is already enqueued (or has been enqueued) for processing”
        boolean[] inQueue = new boolean[n];
        // visited[b] == true means “we have already opened/processed box b and collected its candies/keys/containedBoxes”
        boolean[] visited = new boolean[n];
        // isClosed[b] == true means “we know about box b, but its status==0 and we do *not* have its key yet”
        boolean[] isClosed = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        // 1) Seed with all of the initialBoxes:
        for (int box : initialBoxes) {
            if (status[box] == 1) {
                // already unlocked/open → enqueue it
                queue.offer(box);
                inQueue[box] = true;
            } else {
                // closed & no key yet
                isClosed[box] = true;
            }
        }

        int result = 0;

        // Process everything currently in the queue
        while (!queue.isEmpty()) {
            int b = queue.poll();

            if (visited[b]) {
                // already opened this box before; skip
                continue;
            }
            visited[b] = true;

            // 2) Collect candies
            result += candies[b];

            // 3) Collect any keys inside box b:
            for (int k : keys[b]) {
                if (!haveKey[k]) {
                    haveKey[k] = true;
                    // If that key matches a box we had marked closed, we can now enqueue it:
                    if (isClosed[k] && !inQueue[k]) {
                        queue.offer(k);
                        inQueue[k] = true;
                        isClosed[k] = false; // no longer closed
                    }
                }
            }

            // 4) Look at all boxes that box b contains
            for (int nextBox : containedBoxes[b]) {
                if (visited[nextBox] || inQueue[nextBox]) {
                    // either we’ve already opened it, or it’s already queued to open → skip
                    continue;
                }

                if (status[nextBox] == 1 || haveKey[nextBox]) {
                    // either it’s unlocked (status==1) or we already have its key
                    queue.offer(nextBox);
                    inQueue[nextBox] = true;
                } else {
                    // still locked, and we don’t have the key yet
                    isClosed[nextBox] = true;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = {{}, {}, {1}, {}};
        int[][] containedBoxes = {{1,2}, {3}, {}, {}};
        int[] initialBoxes = {0};
        Candies_1298 sol = new Candies_1298();
        System.out.println(sol.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
}
