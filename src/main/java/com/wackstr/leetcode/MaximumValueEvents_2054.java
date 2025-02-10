package com.wackstr.leetcode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/*
2024-12-13
 */
public class MaximumValueEvents_2054 {

    private static final int EVENT_START_TIME = 0;
    private static final int EVENT_END_TIME = 1;
    private static final int EVENT_VALUE = 2;


    public int maxTwoEvents(int[][] events) {
        int max = 0;
        // sorted by start time
        // O(N.LOG N)
        Arrays.sort(events, Comparator.comparingInt(a -> a[EVENT_START_TIME]));
        // O(N)
        int[][] endingEvents = Arrays.copyOf(events, events.length);
        // O(N.LOG N)
        Arrays.sort(endingEvents, Comparator.comparingInt(a -> a[EVENT_END_TIME]));

        // O(N)
        int[] startingMaxFromRight = new int[events.length];
        startingMaxFromRight[events.length - 1] = events[events.length - 1][EVENT_VALUE];
        for(int i = events.length - 2; i >= 0; i--){
            startingMaxFromRight[i] = Math.max(events[i][EVENT_VALUE], startingMaxFromRight[i+1]);
        }

        // O(N)
        int[] endingMaxFromLeft = new int[events.length];
        endingMaxFromLeft[0] = endingEvents[0][EVENT_VALUE];
        for(int i = 1; i < endingEvents.length; i++){
            endingMaxFromLeft[i] = Math.max(endingEvents[i][EVENT_VALUE], endingMaxFromLeft[i-1]);
        }

        // O(N.LOG N))
        for(int i = 0; i < events.length; i++){
            int[] currEvent = events[i];
            int maxBefore = getMaxEventValueAfter(
                    currEvent[EVENT_END_TIME],
                    events,
                    startingMaxFromRight);
            int maxAfter = getMaxEventValueBefore(
                    currEvent[EVENT_START_TIME],
                    endingEvents,
                    endingMaxFromLeft
            );
            max = Math.max(max, currEvent[EVENT_VALUE] + Math.max(maxBefore, maxAfter));

        }

        return max;
    }

    private int getMaxEventValueBefore(
            int startTime,
            int[][] events,
            int[] endingMaxFromLeft) {
        int left = 0;
        int right = events.length - 1;
        if(events[left][EVENT_END_TIME] < startTime){
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(mid == left) mid = right;
                if (events[mid][EVENT_END_TIME] < startTime) left = mid;
                else right = mid - 1;
            }
            return endingMaxFromLeft[left];
        }
        return 0;
    }

    private int getMaxEventValueAfter(
            int endTime,
            int[][] events,
            int[] startingMaxFromRight) {
        int left = 0;
        int right = events.length - 1;
        if(events[right][EVENT_START_TIME] > endTime){
            while(left < right) {
                int mid = left + (right - left) / 2;
                if (events[mid][EVENT_START_TIME] > endTime) right = mid;
                else left = mid + 1;
            }
            return startingMaxFromRight[left];
        }
        return 0;
    }

    private int approach_timeout(int[][] events) {
        int max = 0;
        PriorityQueue<int[]> eventQueue = new PriorityQueue<>((a,b) -> b[EVENT_VALUE] - a[EVENT_VALUE]);
        Collections.addAll(eventQueue, events);

        while(!eventQueue.isEmpty()){
            int[] currEvent = eventQueue.poll();
            int currMax = currEvent[EVENT_VALUE];
            if(!eventQueue.isEmpty()) {
                Set<int[]> unusedEvents = new HashSet<>();
                while (!eventQueue.isEmpty()) {
                    int[] candidateEvent = eventQueue.poll();
                    if (isDisjoint(currEvent, candidateEvent)) {
                        currMax += candidateEvent[EVENT_VALUE];
                        break;
                    } else {
                        unusedEvents.add(candidateEvent);
                    }
                }
                eventQueue.addAll(unusedEvents);
            }
            max = Math.max(max, currMax);
        }
        return max;
    }

    private boolean isDisjoint(int[] currEvent, int[] candidateEvent) {
        return currEvent[EVENT_START_TIME] > candidateEvent[EVENT_END_TIME]
                || currEvent[EVENT_END_TIME] < candidateEvent[EVENT_START_TIME];
    }

    public static void main(String[] args) {
        MaximumValueEvents_2054 sol = new MaximumValueEvents_2054();
        int[][] events = {{1,5,3},{1,5,1}, {6,6,5}};

//        String fileName = "2054_data.txt";
//        // Load the file from resources
//        try (InputStream inputStream = MaximumValueEvents_2054.class.getClassLoader().getResourceAsStream(fileName);
//             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//
//            // Read file line by line
//            List<int[]> eventList = new ArrayList<>();
//            Stream<String> lines = reader.lines();
//            lines.forEach(l -> {
//                String[] eventStr = l.split(",");
//                int[] event = new int[]{
//                        Integer.parseInt(eventStr[0]),
//                Integer.parseInt(eventStr[1]),
//                    Integer.parseInt(eventStr[2])};
//                eventList.add(event);
//
//            });
//
//            events = eventList.toArray(new int[][]{});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        System.out.println(sol.maxTwoEvents(events));
    }
}
