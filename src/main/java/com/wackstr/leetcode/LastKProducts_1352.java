package com.wackstr.leetcode;

import java.util.ArrayList;

/*
2025-02-14
 */
public class LastKProducts_1352 {
    public static class ProductOfNumbers {

        private ArrayList<Integer> products;
        private int currCount;

        public ProductOfNumbers() {
            initialize();
        }

        private void initialize() {
            products = new ArrayList<>();
            currCount = 0;
            products.add(1);
        }

        public void add(int num) {
            if(num == 0){
                initialize();
            }else{
                currCount++;
                products.add(currCount, products.get(currCount - 1) * num);
            }
        }

        public int getProduct(int k) {
            if(k > currCount) return 0;
            return products.get(currCount)/products.get(currCount - k);
        }
    }

    public static void main(String[] args) {
        ProductOfNumbers sol = new ProductOfNumbers();
        sol.add(3);
        sol.add(0);
        sol.add(2);
        sol.add(5);
        sol.add(4);
        System.out.println(sol.getProduct(2));
        System.out.println(sol.getProduct(3));
        System.out.println(sol.getProduct(4));
        sol.add(8);
        System.out.println(sol.getProduct(2));

    }
}
