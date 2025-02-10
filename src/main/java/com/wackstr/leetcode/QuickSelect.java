package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSelect {

    public <T extends Comparable<T>> T select(int index, List<T> items){
        int i = items.size()/2;
        T currItem = items.get(i);
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
        for(int k = 0; k < items.size(); k++){
            if(k != i){
                if(items.get(k).compareTo(currItem) < 0){
                    left.add(items.get(k));
                }else{
                    right.add(items.get(k));
                }
            }
        }
        int currIndex = left.size();
        if(currIndex == index) return currItem;
        else if (currIndex < index) return select(index - currIndex - 1, right);
        else return select(index,  left);
    }


    public static void main(String[] args) {
        Integer[] nums = {2,1,7,4};
        QuickSelect qs = new QuickSelect();
        System.out.println(qs.select(2, Arrays.stream(nums).toList()));
    }
}
