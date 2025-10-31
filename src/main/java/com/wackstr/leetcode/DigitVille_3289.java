package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2025-10-31
 */
public class DigitVille_3289 {
    public int[] getSneakyNumbers(int[] nums){
        int[] res = new int[2];
        boolean[] found = new boolean[101];
        int i = 0;
        for(int num : nums){
            if(found[num]) res[i++] = num;
            found[num] = true;
        }
        return res;
    }
}
