package com.wackstr.leetcode;

/*
2025-12-20 944
 */
public class DeleteColumns_944 {
    public int minDeletionSize(String[] strs){
        if(strs.length == 1) return 0;
        int cols = strs[0].length();
        int n = strs.length;
        int cnt = 0;
        for(int col = 0; col < cols; col++){
            char curr = strs[0].charAt(col);
            for(int i = 1; i < n; i++){
                char next = strs[i].charAt(col);
                if(next < curr) {
                    cnt++;
                    break;
                }
                curr = next;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] strs = {"cba","daf","ghi"};
        DeleteColumns_944 sol = new DeleteColumns_944();
        System.out.println(sol.minDeletionSize(strs));
    }
}
