package com.wackstr.leetcode;

/*
2025-07-10
 */
public class RescheduleMeetings_3304 {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime){
        int n = startTime.length;

        // get all the gaps
        int[] gaps = new int[n+1];
        gaps[0] = startTime[0];
        gaps[n] = eventTime - endTime[n-1];
        for(int i = 1; i < n; i++){
            gaps[i] = startTime[i] - endTime[i-1];
        }

        /*
        leftMax gives maximum gap up to event i
        rightMax gives maximum gap after event i
         */
        int[] leftMax = new int[n+1];
        int[] rightMax = new int[n+1];
        int currLeft = -1;
        int currRight = -1;
        for(int i = 0; i < gaps.length; i++){
            currLeft = Math.max(gaps[i], currLeft);
            currRight = Math.max(gaps[n-i], currRight);
            leftMax[i] = currLeft;
            rightMax[n-i] = currRight;
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            int duration = endTime[i] - startTime[i];

            /*
            get the maximum gap available amongst non-adjacent gaps to
            the event
             */
            int leftPocket = i > 0 ? leftMax[i - 1] : 0;
            int rightPocket = i < n - 1 ? rightMax[i + 2] : 0;
            int maxPocket = Math.max(leftPocket, rightPocket);

            /*
            If we can put the event in a non-adjacent gap, we can then consider
            the sum of the duration plus the sum of adjacent events as a
            candidate, otherwise we can shift the event withing this gap range
            to give a candidate equal to the sum of the adjacent gaps
             */
            boolean canShift = duration <= maxPocket;
            int curr = canShift ? gaps[i] + gaps[i+1] + duration :
                    gaps[i] + gaps[i+1];
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        // 30
        int eventTime = 54;
        int[] startTime = {9,24, 45, 50, 53};
        int[] endTime = {15,26, 50, 53, 54};
        RescheduleMeetings_3304 sol = new RescheduleMeetings_3304();
        System.out.println(sol.maxFreeTime(eventTime, startTime, endTime));
    }
}
