package com.wackstr.leetcode;

/*
2026-06-18 1344
 */
public class ClockAngle_1344 {
    public double angleClock(int hour, int minutes) {
        /*
        12 hours - 60 degrees
        60 minutes - 60 degrees
        360/12 is the rotation of the hour angle on 60 minutes
         */
        double minuteAngle = minutes*6.0;
        double hourAngle = 30.0*((hour % 12) + minutes/60.0);
        double angle = Math.abs(hourAngle - minuteAngle);
        return Math.min(angle, 360-angle);
    }

    public static void main(String[] args) {
        int hour = 3;
        int minutes = 30;
        ClockAngle_1344 sol = new ClockAngle_1344();
        System.out.println(sol.angleClock(hour, minutes));
    }
}
