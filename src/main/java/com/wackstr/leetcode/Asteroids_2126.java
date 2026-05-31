package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-05-31 2126
 */
public class Asteroids_2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids){
        Arrays.sort(asteroids);
        long runningMass = mass;
        for (int asteroid : asteroids) {
            if(runningMass >= asteroid) runningMass += asteroid;
            else return false;
        }
        return true;
    }
}
