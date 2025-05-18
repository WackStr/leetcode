package com.wackstr.leetcode.learn.HashMap;

import java.util.*;

public class LeastIndexCommonString {
    public String[] findRestaurant(String[] list1, String[] list2){
        Map<String, Integer> m1 = new HashMap<>();
        List<String> candidates = new ArrayList<>();
        for(int i = 0; i < list1.length; i++){
            m1.put(list1[i], i);
        }
        int minScore = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++){
            if(m1.containsKey(list2[i])){
                int currScore = m1.get(list2[i]) + i;
                if(currScore < minScore){
                    candidates = new ArrayList<>();
                    candidates.add(list2[i]);
                    minScore = currScore;
                }else if (currScore == minScore) candidates.add(list2[i]);
            }
        }
        return candidates.toArray(new String[0]);
    }


}
