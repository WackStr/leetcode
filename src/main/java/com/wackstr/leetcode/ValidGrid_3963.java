package com.wackstr.leetcode;

/*
2026-10-27 3963
 */
public class ValidGrid_3963 {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < n; i++) {
            row.append('.');
        }
        res[0] = row.toString();
        for(int i = 1; i < m; i++){
            row = new StringBuilder();
            for (int j = 0; j < n - 1; j++) {
                row.append('#');
            }
            row.append('.');
            res[i] = row.toString();
        }
        return res;
    }
}
