package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
2025-07-11
 */
public class MeetingRooms_2402 {
    public int mostBooked(int n, int[][] meetings){
        int[] bookings = new int[n];

        // count bookings through simulation
        /*
        Rules to follow:
        1. Unused room with the lowest number
        2. Take the meeting with the earliest original start time
        3. if no room available - delay meeting
         */

        // will help pick unused numbers in increasing order
        Queue<Integer> unusedRooms = new PriorityQueue<>();
        /*
         [room number, end time of current meeting] for booked rooms
         This would give us the earliest available room from booked
         */
        Queue<int[]> bookedRooms =
                new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        // to get the earliest starting meetings
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // initialize the collections with unused rooms and meetings
        for (int i = 0; i < n; i++) unusedRooms.offer(i);


        // process all meetings
        int nextRoom;
        int endTime;
        for(int[] nextMeeting : meetings){
            // Release rooms with finished meetings:
            while(!bookedRooms.isEmpty() && bookedRooms.peek()[1] <= nextMeeting[0]){
                int[] releasedRoom = bookedRooms.poll();
                unusedRooms.offer(releasedRoom[0]);
            }

            // assign the smallest non-booked room
            if(!unusedRooms.isEmpty()){
                nextRoom = unusedRooms.poll();
                endTime = nextMeeting[1];
            }else{
                // else wait for the earliest booked room
                int[] bookedRoom = bookedRooms.poll();
                nextRoom = bookedRoom[0];
                endTime = bookedRoom[1] <= nextMeeting[0] ?
                        nextMeeting[1] :
                        bookedRoom[1] + (nextMeeting[1] - nextMeeting[0]);
            }
            bookedRooms.offer(new int[]{nextRoom, endTime});
            bookings[nextRoom]++;
        }

        // get the earliest room with the maximum bookings
        int maxRoom = -1;
        int maxCount = -1;
        for (int i = 0; i < bookings.length; i++) {
            if(bookings[i] > maxCount) {
                maxRoom = i;
                maxCount = bookings[i];
            }
        }
        return maxRoom;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = {{0,10}, {1, 5}, {2, 7}, {3,4}};
        MeetingRooms_2402 sol = new MeetingRooms_2402();
        System.out.println(sol.mostBooked(n, meetings));
    }
}
