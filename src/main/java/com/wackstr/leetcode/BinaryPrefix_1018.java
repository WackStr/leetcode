package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2025-11-24 1018
 */
public class BinaryPrefix_1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int prefix = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }
}
