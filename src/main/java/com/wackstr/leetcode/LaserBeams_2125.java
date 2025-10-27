package com.wackstr.leetcode;

/*
2025-10-27
 */
public class LaserBeams_2125 {
    public int numberOfBeams(String[] bank){
        int curr = countLasers(bank[0]);
        int total = 0;
        for(int i = 1; i < bank.length; i++){
            int next = countLasers(bank[i]);
            if(next > 0){
                total += next * curr;
                curr = next;
            }
        }
        return total;
    }

    private int countLasers(String row) {
        int lasers = 0;
        for(int i = 0; i < row.length(); i++){
            if(row.charAt(i) == '1') lasers++;
        }
        return lasers;
    }
}
