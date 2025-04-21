package com.wackstr.leetcode.learn.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> lastRow = new ArrayList<>();
        lastRow.add(1);
        rows.add(lastRow);
        while(--numRows > 0){
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(lastRow.get(0));
            for(int i = 0; i < lastRow.size() - 1; i++){
                nextRow.add(lastRow.get(i) + lastRow.get(i + 1));
            }
            nextRow.add(lastRow.get(lastRow.size()-1));
            rows.add(nextRow);
            lastRow = nextRow;
        }
        return rows;
    }

    public static void main(String[] args) {
        int n = 5;
        PascalTriangle sol = new PascalTriangle();
        System.out.println(sol.generate(n));
    }
}
