package com.wackstr.leetcode;


import java.util.Arrays;

/*
2025-01-06
 */
public class OperationsToMoveBalls_1769 {
    public int[] minOperations(String boxes){
        int[] leftScan = new int[boxes.length()];
        int[] rightScan = new int[boxes.length()];
        int x = getBoxCount(boxes, 0);
        for(int i = 1; i < boxes.length(); i++){
            leftScan[i] = x + leftScan[i-1];
            x += getBoxCount(boxes, i);
        }
        x = getBoxCount(boxes, boxes.length() - 1);
        for(int i = boxes.length() - 2; i >= 0; i--){
            rightScan[i] = x + rightScan[i+1];
            x += getBoxCount(boxes, i);
        }
        for(int i = 0; i < leftScan.length; i++){
            leftScan[i] = leftScan[i] + rightScan[i];
        }
        return leftScan;
    }

    public int getBoxCount(String boxes, int index){
        return boxes.charAt(index) == '0' ? 0 : 1;
    }

    public static void main(String[] args) {
        String boxes = "110";
        OperationsToMoveBalls_1769 sol = new OperationsToMoveBalls_1769();
        System.out.println(Arrays.toString(sol.minOperations(boxes)));
    }
}
