package com.wackstr.leetcode.learn.queue;

import java.util.*;

/*
2025-06-20
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target){
        Set<String> exitPoints = new HashSet<>();
        Collections.addAll(exitPoints, deadends);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int res = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            while(n > 0){
                String curr = queue.poll();
                if(!exitPoints.contains(curr)) {
                    if (curr.equals(target)) return res;
                    for (int i = 0; i < 4; i++) {
                        int digit = curr.charAt(i) - '0';
                        // (digit + 1) % 10; (digit + 9) % 10
                        StringBuilder sb_ahead = new StringBuilder();
                        sb_ahead.append(curr);
                        sb_ahead.setCharAt(i, (char) ('0' + (digit + 1) % 10));
                        String ahead = sb_ahead.toString();
                        if (!visited.contains(ahead)) {
                            queue.offer(ahead);
                            visited.add(ahead);
                        }
                        StringBuilder sb_behind = new StringBuilder();
                        sb_behind.append(curr);
                        sb_behind.setCharAt(i, (char) ('0' + (digit + 9) % 10));
                        String behind = sb_behind.toString();
                        if (!visited.contains(behind)) {
                            queue.offer(behind);
                            visited.add(behind);
                        }
                    }
                }
                n--;
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        OpenTheLock sol = new OpenTheLock();
        System.out.println(sol.openLock(deadends, target));
    }
}
