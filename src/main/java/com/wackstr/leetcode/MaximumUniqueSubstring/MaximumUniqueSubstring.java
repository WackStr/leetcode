package com.wackstr.leetcode.MaximumUniqueSubstring;

import java.util.HashSet;
import java.util.Set;

/*1593
2024-10-21
 */
public abstract class MaximumUniqueSubstring {

    public abstract int maxUniqueSplit(String s);

    public static void main(String[] args) {
        String s = "wwwzfvedwfvhsww";
        MaximumUniqueSubstring sol = new MaximumUniqueSubstringScan();
        int cnt = sol.maxUniqueSplit(s);
        System.out.println(cnt);
    }

}
