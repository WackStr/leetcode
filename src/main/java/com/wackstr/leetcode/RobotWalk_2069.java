package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-04-07 2069
 */
public class RobotWalk_2069 {

    private static class Robot {

        private final int perimeter;
        private final int width;
        private final int height;
        private int steps;
        private boolean hasMoved;

        public Robot(int width, int height) {
           perimeter = 2 * (width + height) - 4;
           steps = 0;
           hasMoved = false;
           this.width = width;
           this.height = height;
        }

        public void step(int num) {
            hasMoved = true;
           steps = (steps + num) % perimeter;
        }

        public int[] getPos() {
            int curr = steps;
            if(curr < width) return new int[]{curr, 0};
            curr -= (width-1);
            if(curr < height) return new int[]{width - 1, curr};
            curr -= (height-1);
            if(curr < width) return new int[]{width - curr - 1, height - 1};
            curr -= (width-1);
            return new int[]{0, height - curr - 1};
        }

        public String getDir() {
            if(steps == 0) return hasMoved ? "South" : "East";
            int curr = steps;
            if(curr < width) return "East";
            curr -= (width-1);
            if(curr < height) return "North";
            curr -= (height-1);
            if(curr < width) return "West";
            return "South";
        }
    }

    public static void main(String[] args) {
        RobotWalk_2069.Robot robot = new Robot(2, 2);
        for (int i = 0; i < 9; i++) {
            System.out.println(robot.getDir() + "-" + Arrays.toString(robot.getPos()));
            robot.step(1);
            System.out.println(">>");
        }

    }
}
