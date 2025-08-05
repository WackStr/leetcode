package com.wackstr.leetcode;

/*
2025-08-05
 */
public class FruitBasket_3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt = 0;
        for(int i = 0; i < baskets.length; i++){
            int fruit = fruits[i];
            boolean placed = false;
            for(int j = 0; j < baskets.length; j++){
                if(baskets[j] != -1 && baskets[j] >= fruit){
                    baskets[j] = -1;
                    placed = true;
                    break;
                }
            }
            if(!placed) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] fruits = {3, 6, 1};
        int[] baskets = {6, 4, 7};
        FruitBasket_3477 sol = new FruitBasket_3477();
        System.out.println(sol.numOfUnplacedFruits(fruits, baskets));
    }
}
