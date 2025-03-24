package com.wackstr.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

/*
2025-03-24
 */
public class DaysWithoutMeeting_3169 {

    public int countDays(int days, int[][] meetings) {
        Queue<int[]> mergedMeetings = getMergedMeetings(meetings);
        int busyDays = getTotalBusyDays(mergedMeetings);
        return days - busyDays;
    }

    private int getTotalBusyDays(Queue<int[]> mergedMeetings) {
        int busyDays = 0;
        for(int[] meeting : mergedMeetings){
            busyDays += meeting[1] - meeting[0] + 1;
        }
        return busyDays;
    }

    private Queue<int[]> getMergedMeetings(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> mergedMeetings = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        while(left < meetings.length){
            int currEnd = meetings[left][1];
            while(right < meetings.length
                    && meetings[right][0] <= currEnd){
                currEnd = Math.max(currEnd, meetings[right][1]);
                right++;
            }
            mergedMeetings.add(new int[]{meetings[left][0], currEnd});
            left = right;
        }
        return mergedMeetings;
    }

    private static int countDaysThroughSweep(int days, int[][] meetings) {
    /*
    days + 2 because days are 1 indexed and when doing linesweep
    the meeting count is reduced on the next day
     */
        int[] lineSweep = new int[days +2];

        // add all deltas from meetings
        for(int[] meeting : meetings) {
            // meeting count is increased on the day the meeting starts
            lineSweep[meeting[0]]++;
            // meeting count is reduced the next day after meeting ends
            lineSweep[meeting[1]+1]--;
        }

        /*
        Use linesweep to see currently active meetings from day 1
        to last day (lineSweep.length - 2)
        Count days where there are 0 active meetings
         */
        int freeDays = 0;
        int currentMeetings = 0;
        for(int i = 1; i < lineSweep.length - 1; i++){
            currentMeetings += lineSweep[i];
            if(currentMeetings == 0) freeDays++;
        }
        return freeDays;
    }

    public static void main(String[] args) {
        int days = 14;
        int[][] meetings = {{6,11}, {7,13}, {8,9}, {5,8}, {3, 13}, {11, 13}, {1,3}, {5,10},{8,13}, {3,9}};
        DaysWithoutMeeting_3169 sol = new DaysWithoutMeeting_3169();
        System.out.println(sol.countDays(days, meetings));
    }
}
