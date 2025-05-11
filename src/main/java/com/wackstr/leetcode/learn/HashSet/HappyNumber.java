package com.wackstr.leetcode.learn.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n){
        Set<Integer> nums = new HashSet<>();
        int next = getNext(n);
        while(!nums.contains(next)){
            if(next == 1) return true;
            nums.add(next);
            next = getNext(next);
        }
        return false;
    }

    private int getNext(int n) {
        int res = 0;
        while(n > 0){
            int d = n % 10;
            res += d * d;
            n /= 10;
        }
        return res;
    }
}
