package com.wackstr.leetcode;

/*
2026-04-05 657
 */
public class RobotMovement_657 {
    public boolean judgeCircle(String moves){
        int right=0;
        int up=0;
        for(final char c:moves.toCharArray()) {
            switch(c) {
                case 'R':
                    right++;
                    break;
                case 'L':
                    right--;
                    break;
                case 'U':
                    up++;
                    break;
                case 'D':
                    up--;
                    break;
            }
        }
        return right==0 && up==0;
    }
}
