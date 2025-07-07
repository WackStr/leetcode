package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
2025-07-07
 */
public class EventAttendance_1353 {

    public int maxEvents(int[][] events){
        Arrays.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Queue<int[]> defer = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int cnt = 0;
        int currDay = 1;
        for (int[] event : events) {
            if (defer.isEmpty()) currDay = Math.max(event[0], currDay);

            while (currDay < event[0]) {
                while (!defer.isEmpty() && defer.peek()[1] < currDay) defer.poll();
                if (!defer.isEmpty()) {
                    int[] candidate = defer.poll();
                    currDay = Math.max(candidate[0], currDay);
                    cnt++;
                    currDay++;
                } else {
                    currDay = event[0];
                }
            }

            if (currDay == event[1]) {
                cnt++;
                currDay++;
            } else if (currDay < event[1]) {
                defer.add(event);
            }
        }
        while(!defer.isEmpty()) {
            while (!defer.isEmpty() && defer.peek()[1] < currDay) defer.poll();
            if (!defer.isEmpty()) {
                int[] candidate = defer.poll();
                currDay = Math.max(candidate[0], currDay);
                cnt++;
                currDay++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] events = {{1,5}, {1,5}, {1,5}, {3,4}, {3,5}};
        EventAttendance_1353 sol = new EventAttendance_1353();
        System.out.println(sol.maxEvents(events));
    }
}
