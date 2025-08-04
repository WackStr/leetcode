package com.wackstr.leetcode;

/*
2025-08-04
 */
public class FruitBasket_904 {
    public int totalFruit(int[] fruits){
        int fruit1 = -1;
        int i1 = 0;
        int fruit2 = -1;
        int i2 = 0;
        int startIndex = 0;
        int longestLength = 0;
        for(int i = 0; i < fruits.length; i++){
            if(fruit1 == -1){
                fruit1 = fruits[i];
                i1 = i;
            }else if(fruit2 == -1 && fruits[i] != fruit1){
                fruit2 = fruits[i];
                i2 = i;
            }else if(fruits[i] == fruit1){
                i1 = i;
            }else if(fruits[i] == fruit2){
                i2 = i;
            }else{
                longestLength = Math.max(longestLength, i - startIndex);
                if(i1 > i2){
                    startIndex = i2 + 1;
                    fruit2 = fruits[i];
                    i2 = i;
                }else{
                    startIndex = i1 + 1;
                    fruit1 = fruits[i];
                    i1 = i;
                }
            }
        }
        longestLength = Math.max(longestLength, fruits.length - startIndex);
        return longestLength;
    }

    public static void main(String[] args) {
        int[] fruits = {0,0,1,1};
        FruitBasket_904 sol = new FruitBasket_904();
        System.out.println(sol.totalFruit(fruits));
    }
}
