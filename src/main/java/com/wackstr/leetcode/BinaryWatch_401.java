package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2026-02-17 401
 */
public class BinaryWatch_401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int turnedOn = 1;
        BinaryWatch_401 sol = new BinaryWatch_401();
        System.out.println(sol.readBinaryWatch(turnedOn));
    }
}
