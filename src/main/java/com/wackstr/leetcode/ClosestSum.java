package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ClosestSum {
    public record Item(String key, double amount){}
    public record Bag(String itemCodes, double value){}

    public Bag closestSum(Item[] items, double target){
        if(items == null || items.length == 0 )
            return new Bag("", 0);
        Arrays.sort(items, Comparator.comparingDouble(Item::amount));
        Set<Item> currItems = new HashSet<>();
        return processNextItem("", 0, currItems, items[0], items, 0, target);
    }

    private Bag processNextItem(String currCode, double currSum, Set<Item> currItems, Item item, Item[] items, int index, double target){
        currItems.add(item);
        Bag bagWith = evaluate(currCode + "-" + item.key, currSum + item.amount(), items, currItems, index + 1, target);
        Bag bagWithout = evaluate(currCode, currSum, items, currItems,index + 1, target);
        if(bagWith.value >= bagWithout.value) {
            return bagWith;
        }else{
            currItems.remove(item);
            return bagWithout;
        }
    }

    private Bag evaluate(String currCode, double currSum, Item[] items, Set<Item> currItems, int i, double target) {
        if(i >= items.length || items[i].amount() > target - currSum) return new Bag(currCode, currSum);
        return processNextItem(currCode, currSum, currItems, items[i], items, i, target);
    }

    public static void main(String[] args) {
        double[] prices = {2550, 150, 1050, 2500, 3600, 2748, 5439, 3600, 2000};
        int n = prices.length;
        Item[] items = new Item[n];
        for(int i = 0; i < n; i++){
            items[i] = new Item("i" + i, prices[i]);
        }
        double target = 17637;
        ClosestSum sol = new ClosestSum();
        System.out.println(sol.closestSum(items, target));
    }


}
