package com.wackstr.leetcode;

/*
2025-05-03
 */
public class RotateDominoes_1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) return rotations;
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0;
        int rotateBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1; // Can't make row with this target
            } else if (tops[i] != target) {
                rotateTop++; // Need to rotate top[i] to match
            } else if (bottoms[i] != target) {
                rotateBottom++; // Need to rotate bottom[i] to match
            }
        }
        return Math.min(rotateTop, rotateBottom);
    }

    public static void main(String[] args) {
        int[] tops = {1,2,1,1,1,2,2,2};
        int[] bottoms = {2,1,2,2,2,2,2,2};
        RotateDominoes_1007 sol = new RotateDominoes_1007();
        System.out.println(sol.minDominoRotations(tops, bottoms));

    }
}
