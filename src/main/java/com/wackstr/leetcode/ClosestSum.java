package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ClosestSum {
    public record Item(String key, double amount){}
    public record Bag(Set<Item> items, double value){}

    public Bag closestSum(Item[] items, double target){
        if(items == null || items.length == 0 )
            return new Bag(new HashSet<>(), 0);
        Arrays.sort(items, Comparator.comparingDouble(Item::amount));
        Set<Item> currItems = new HashSet<>();
        return processNextItem(0, currItems, items[0], items, 0, target);
    }

    private Bag processNextItem(double currSum, Set<Item> currItems, Item item, Item[] items, int index, double target){
        currItems.add(item);
        Bag bagWith = evaluate(currSum + item.amount(), items, currItems, index + 1, target);
        Bag bagWithout = evaluate(currSum, items, currItems,index + 1, target);
        if(bagWith.value >= bagWithout.value) {
            return bagWith;
        }else{
            currItems.remove(item);
            return bagWithout;
        }
    }

    private Bag evaluate(double currSum, Item[] items, Set<Item> currItems, int i, double target) {
        if(i >= items.length || items[i].amount() > target - currSum) return new Bag(currItems, currSum);
        return processNextItem(currSum, currItems, items[i], items, i, target);
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item("i0", 0.1),
                new Item("i1", 0.2),
                new Item("i2", 0.35)};
        double target = 0.36;
        ClosestSum sol = new ClosestSum();
        System.out.println(sol.closestSum(items, target));
    }


}
