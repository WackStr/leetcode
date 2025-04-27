package com.wackstr.leetcode.learn.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex){
        List<Integer> lastRow = List.of(1);
        while(rowIndex-- > 0){
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(lastRow.get(0));
            for(int i = 1; i < lastRow.size(); i++){
                nextRow.add(lastRow.get(i-1) + lastRow.get(i));
            }
            nextRow.add(lastRow.get(lastRow.size()-1));
            lastRow = nextRow;
        }
        return lastRow;
    }

    public static void main(String[] args) {
        int rowIndex = 3;
        PascalTriangleII sol = new PascalTriangleII();
        System.out.println(sol.getRow(rowIndex));
    }
}
