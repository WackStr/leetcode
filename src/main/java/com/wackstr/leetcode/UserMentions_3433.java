package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2025-12-12 3433
 */
public class UserMentions_3433 {
    
    private static final String MESSAGE = "MESSAGE";
    
    public int[] countMentions(int numberOfUsers, List<List<String>> events){
        int[] mentions = new int[numberOfUsers];
        int allIncrements = 0;
        int[] onlineCutoff = new int[numberOfUsers];
        events.sort((a, b) -> {
            int ta = Integer.parseInt(a.get(1));
            int tb = Integer.parseInt(b.get(1));
            if(ta == tb) return !a.get(0).equals(MESSAGE) ? -1 : 1;
            else return ta - tb;
        });
        for (List<String> event : events) {
            int t = Integer.parseInt(event.get(1));
            if(event.get(0).equals(MESSAGE)){
                String mentionString = event.get(2);
                if(mentionString.equals("ALL")){
                    allIncrements++;
                }else if(mentionString.equals("HERE")){
                    // only online
                    for (int i = 0; i < mentions.length; i++)
                        if(onlineCutoff[i] <= t) mentions[i]++;
                }else{
                    // id string
                    for (String id : mentionString.split(" "))
                        mentions[Integer.parseInt(id.substring(2))]++;
                }
            }else{
                // offline
                int id = Integer.parseInt(event.get(2));
                onlineCutoff[id] = t + 60;
            }
        }
        if(allIncrements > 0) {
            for (int i = 0; i < mentions.length; i++) {
                mentions[i] += allIncrements;
            }
        }
        return mentions;
    }

    public static void main(String[] args) {
        int numberOfUsers = 3;
        String[][] e = {{MESSAGE,"2","HERE"},{"OFFLINE","2","1"},{"OFFLINE","1","0"},{MESSAGE,"61","HERE"}};
        List<List<String>> events = new ArrayList<>();
        for (String[] event : e)
            events.add(Arrays.asList(event));
        UserMentions_3433 sol = new UserMentions_3433();
        System.out.println(Arrays.toString(sol.countMentions(numberOfUsers, events)));
    }
}
