package com.wackstr.leetcode;

/*
2025-01-17
*/
public class NeighboringBitwiseXOR_2683 {

    /*

         0 ^ 0 = 0
         0 ^ 1 = 1
         1 ^ 0 = 1
         1 ^ 1 = 0

         derived = [1,1,0]

        [
            [[0,1], [1,0]],
            [[0,1], [1,0]],
            [[0,0], [1,1]]
        ]

        (0, 1, 0), (1,0, 1)

        [0^1, 1^0, 0^0] = [1, 1, 0] = derived
        [1^0, 0^1, 1^1] = [1, 1, 0] = derived

        derive = [1, 0]
        [
            [[0,1], [1,0]],
            [[0,0], [1,1]]
        ]

     */
    public boolean doesValidArrayExist(int[] derived) {
        int init = 0;
        for(int i = 0; i < derived.length - 1; i++){
            init ^= derived[i];
        }
        return init == derived[derived.length - 1];
    }



    public static void main(String[] args) {
        int[] derived = {0};
        NeighboringBitwiseXOR_2683 sol = new NeighboringBitwiseXOR_2683();
        System.out.println(sol.doesValidArrayExist(derived));
    }
}
