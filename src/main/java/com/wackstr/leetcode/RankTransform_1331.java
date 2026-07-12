package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
2026-07-12 1331
 */
public class RankTransform_1331 {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp);
        HashMap<Integer,Integer> rm=new HashMap<>();
        int rank=1;
        for(int num:temp){
            if(!rm.containsKey(num)){
                rm.put(num,rank++);
            }
        }
        for(int i=0;i<n;i++){
            temp[i]=rm.get(arr[i]);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        RankTransform_1331 sol = new RankTransform_1331();
        System.out.println(Arrays.toString(sol.arrayRankTransform(arr)));
    }
}
