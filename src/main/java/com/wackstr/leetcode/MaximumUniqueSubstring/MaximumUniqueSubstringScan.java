package com.wackstr.leetcode.MaximumUniqueSubstring;

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubstringScan extends MaximumUniqueSubstring{
    public int maxUniqueSplit(String s) {
        Set<String> ans = new HashSet<>();
        for(int i = 0; i < s.length();){
            int j = i + 1;
            for(; j <= s.length(); j++){
                String capture = s.substring(i, j);
                if(!ans.contains(capture)){
                    ans.add(capture);
                    break;
                }
            }
            System.out.println(ans);
            i = j;
        }
        return ans.size();
    }

    public int maxUniqueSetRecursive(String s){
        if(s != null) {
            if(s.isEmpty()){
                return 0;
            }else{
                Set<String> set = maxUniqueSplitSet(s);
                return set.size();
            }
        }else{
            return 0;
        }
    }

    private Set<String> maxUniqueSplitSet(String s) {
        if(s.length() == 1){
            return Set.of(s);
        }else{
            String firstString = s.substring(0, 1);
            String remainder = s.substring(1);
            return comineSet(firstString, maxUniqueSplitSet(remainder));
        }
    }

    private Set<String> comineSet(String firstString, Set<String> strings) {
        if(strings.contains(firstString)){
            return strings;
        }else{
            Set<String> ans = new HashSet<>(strings);
            ans.add(firstString);
            return ans;
        }
    }

}
