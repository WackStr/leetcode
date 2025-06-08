package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2025-06-08
 */
public class LexicographicalPrint_386 {
    public List<Integer> lexicalOrder(int n){
        List<Integer> res = new ArrayList<>();
        add(1, n, res);
        return res;
    }

    /*
    Add the current element if <= n and then add the next lexicographically
    closest elements recursively
     */
    private void add(int curr, int n, List<Integer> res) {
        if(curr <= n){
            res.add(curr);
            /*
            multiplying by 10  adds just a zero so that is the closest
            lexicographical element
             */
            add(curr * 10, n, res);
            /*
                We can get the next closest element by just adding 1

                However, if the last digit is 9, adding 1 would result in
                multiplication by 10. We will reach this number in its correct
                order if we multiply a smaller number by 10 above

                So we will skip that case here to prevent wrong ordering
                and duplication
             */
            if(curr % 10 != 9) {
                add(curr + 1, n, res);
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;
        LexicographicalPrint_386 sol = new LexicographicalPrint_386();
        System.out.println(sol.lexicalOrder(n));
    }

}
