package com.wackstr.leetcode.learn.HashMap;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {

    private final List<Integer> vals;
    private final Map<Integer, Integer> idx;
    private final ThreadLocalRandom rnd;

    public RandomizedSet() {
        vals = new ArrayList<>();
        idx  = new HashMap<>();
        rnd  = ThreadLocalRandom.current();
    }

    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        idx.put(val, vals.size());
        vals.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer i = idx.get(val);
        if (i == null) return false;
        int last = vals.get(vals.size() - 1);
        // swap positions i and end
        vals.set(i, last);
        idx.put(last, i);
        // remove the last element
        vals.remove(vals.size() - 1);
        idx.remove(val);
        return true;
    }

    public int getRandom() {
        return vals.get(rnd.nextInt(vals.size()));
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.insert(10);
        set.insert(20);
        set.insert(30);
        set.remove(0);
        set.remove(0);
        set.insert(0);
        System.out.println(set.getRandom());
    }
}
