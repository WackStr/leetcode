package com.wackstr.leetcode;

import java.util.*;

public class MostBeautifulItem {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> lookup = getMaximumLookupByPrice(items);
        int[] sortedPrices = updatedLookupToMaxAndReturnSortedPrices(lookup);
        return getMaximumBeautyThroughLookup(queries, sortedPrices, lookup);
    }

    private int[] getMaximumBeautyThroughLookup(int[] queries, int[] sortedPrices, Map<Integer, Integer> lookup) {
        int[] ans = new int[queries.length];
        int minPrice = sortedPrices[0];
        int maxPrice = sortedPrices[sortedPrices.length - 1];
        for(int i = 0; i < queries.length; i++){
            int price = queries[i];
            if(price < minPrice){
                ans[i] = 0;
            }else if(price > maxPrice){
                ans[i] = lookup.get(maxPrice);
            }else{
                int closestPrice = bisect(price, sortedPrices);
                ans[i] = lookup.get(closestPrice);
            }
        }
        return ans;
    }

    private static int[] updatedLookupToMaxAndReturnSortedPrices(Map<Integer, Integer> lookup) {
        Queue<Integer> prices = new PriorityQueue<>();
        prices.addAll(lookup.keySet());
        Set<Integer> keys = lookup.keySet();
        int[] sortedPrices = new int[keys.size()];
        boolean first = true;
        int index = 0;
        Integer oldPrice = 0;
        Integer currPrice;
        while(!prices.isEmpty()){
            if(first){
                first = false;
                oldPrice = prices.poll();
                sortedPrices[index++] = oldPrice;
            }else{
                currPrice = prices.poll();
                sortedPrices[index++] = currPrice;
                if(lookup.get(currPrice) < lookup.get(oldPrice)){
                    lookup.put(currPrice, lookup.get(oldPrice));
                }
                oldPrice = currPrice;
            }
        }
        return sortedPrices;
    }

    private static Map<Integer, Integer> getMaximumLookupByPrice(int[][] items) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int[] currItem : items) {
            if (!lookup.containsKey(currItem[0]) || lookup.get(currItem[0]) < currItem[1]) {
                lookup.put(currItem[0], currItem[1]);
            }
        }
        return lookup;
    }

    private Integer bisect(int price, int[] prices) {
        return bisect(price, 0, prices.length, prices);
    }

    private Integer bisect(int price, int left, int right, int[] prices) {
        if(left >= right - 1) return prices[left];
        int currIndex = (left + right) / 2;
        int currPrice = prices[currIndex];
        if(currPrice > price) return bisect(price, left, currIndex, prices);
        else return bisect(price, currIndex, right, prices);
    }

    public static void main(String[] args) {
        int[][] items = {{193,732},{781,962},{864,954},{749,627},{136,746},{478,548},{640,908},{210,799},{567,715},{914,388},{487,853},{533,554},{247,919},{958,150},{193,523},{176,656},{395,469},{763,821},{542,946},{701,676}};
        int[] queries = {885,1445,1580,1309,205,1788,1214,1404,572,1170,989,265,153,151,1479,1180,875,276,1584};
        MostBeautifulItem sol = new MostBeautifulItem();
        System.out.println(Arrays.toString(sol.maximumBeauty(items, queries)));
    }
}
