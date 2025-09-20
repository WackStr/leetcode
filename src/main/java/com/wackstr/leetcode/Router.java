package com.wackstr.leetcode;

import java.util.*;

/*
2025-09-20 3508
 */
public class Router {

    private final Set<String> idLookup;
    private final ArrayDeque<int[]> queue;
    private final int memoryLimit;
    private final Map<Integer, ArrayList<Integer>> destinationTimestamps;

    public Router(int memoryLimit) {
        this.destinationTimestamps = new HashMap<>();
        idLookup = new HashSet<>();
        queue = new ArrayDeque<>();
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String id = getId(source, destination, timestamp);
        if(idLookup.contains(id)) return false;
        if(queue.size() >= memoryLimit){
            ejectPacket();
        }
        idLookup.add(id);
        queue.offerLast(new int[]{source, destination, timestamp});
        destinationTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    private int[] ejectPacket() {
        int[] packet = queue.pollFirst();
        idLookup.remove(getId(packet));
        if(destinationTimestamps.get(packet[1]).size() == 1){
            destinationTimestamps.remove(packet[1]);
        }else {
            destinationTimestamps.get(packet[1]).remove(0);
        }
        return packet;
    }

    private String getId(int[] packet) {
        return getId(packet[0], packet[1], packet[2]);
    }

    private static String getId(int source, int destination, int timestamp) {
        return String.format("%d|%d|%d", source, destination, timestamp);
    }

    public int[] forwardPacket() {
        if(queue.isEmpty()) return new int[0];
        return ejectPacket();
    }

    public int getCount(int destination, int startTime, int endTime) {
        if(!destinationTimestamps.containsKey(destination)) return 0;
        ArrayList<Integer> timeStamps = destinationTimestamps.get(destination);

        if(timeStamps.get(0) > endTime) return 0;
        if(timeStamps.get(timeStamps.size() - 1) < startTime) return 0;
        return getMaximumIndex(timeStamps, endTime)
                - getMaximumIndex(timeStamps, startTime - 1);
    }

    private int getMaximumIndex(ArrayList<Integer> timeStamps, int target) {
        if(timeStamps.get(0) > target) return -1;
        int left = 0;
        int right = timeStamps.size() - 1;
        int mid;
        int curr;
        while(left < right){
            mid = left + (right - left + 1) / 2;
            curr = timeStamps.get(mid);
            if(curr <= target) left = mid;
            else right = mid - 1;

        }
        return right;
    }

    public static void main(String[] args) {
        Router sol = new Router(3);
        System.out.println(sol.addPacket(1, 4, 90));
        System.out.println(sol.addPacket(2,5,90));
        System.out.println(sol.addPacket(1,4,90));
        System.out.println(sol.addPacket(3, 5, 95));
        System.out.println(sol.addPacket(4,5,105));
        System.out.println(Arrays.toString(sol.forwardPacket()));
        System.out.println(sol.addPacket(5,2,110));
        System.out.println(sol.getCount(5,100,110));

    }
}
