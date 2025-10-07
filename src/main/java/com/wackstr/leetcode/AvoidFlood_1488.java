package com.wackstr.leetcode;

import java.util.*;

/*
2025-10-07
 */
public class AvoidFlood_1488 {

    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        TreeSet<Integer> st = new TreeSet<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) {
                st.add(i);
            } else {
                ans[i] = -1;
                if (mp.containsKey(rains[i])) {
                    Integer it = st.ceiling(mp.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    ans[it] = rains[i];
                    st.remove(it);
                }
                mp.put(rains[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] rains = {0,1,1};
        AvoidFlood_1488 sol = new AvoidFlood_1488();
        System.out.println(Arrays.toString(sol.avoidFlood(rains)));
    }
}
