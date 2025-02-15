package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PunishmentNumber_2698 {

    /*
     these are all the punishing numbers - the square can be broken down into
     substrings that sum to the number itself
     */
    private static final int[] lookup =
            {   1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379,
                    414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991,
                    999, 1000};
    /*
        these are the cumulative sums of the numbers themselves
     */
    private static final int[] squares =
            {1, 82, 182, 1478, 3503, 6528, 13252, 21533, 31334, 41334, 96559,
                    184768, 320929, 457829, 601470, 772866, 1204515, 1660140,
                    2154349, 2725885, 3353149, 4179430, 5022154, 5915179,
                    6844475, 7824575, 8806656, 9804657, 10804657};


    public int punishmentNumber(int n){
        /*
        given the array above we can easily fetch the number that matches in
        the lookup and return the cumulative sum up to that point
         */

        int index = Arrays.binarySearch(lookup, n);
        return index >= 0 ? squares[index] : squares[-index - 2];
    }

    // this method can help figure out if a number is a punishing number
    public boolean isPunishingNumber(int n){
        int square = n * n;
        String str = Integer.toString(square);
        int firstNum = Integer.parseInt(str.substring(0, 1));
        return evaluate(
                0,
                firstNum,
                n,
                str,
                1);
    }

    // helper method for exploring all possible permutations
    public boolean evaluate(int runningSum,
                         int currNumber,
                         int target, String representation, int index){

        /*
        simple exit conditions -
            if reached end - check if sum equals
            if total sum exceeds target - fail early
         */
        if(index > representation.length() - 1) {
            return runningSum + currNumber == target;
        }else if(runningSum + currNumber> target){
            return false;
        }
        int digit = Integer.parseInt(representation.substring(index, index+1));
        /*
         first case is when we take the current digit in the running number
         the second case is when we start tracking a new number. We will add
         it to the running sum and start a new number
         expressing this way also helps with short-circuiting
         */
        return
                // keep using next digit
                evaluate(
                        runningSum,
                        currNumber*10 + digit,
                        target,
                        representation,
                        index+1)
                ||
                // start a new digit and add current number to running sum
                evaluate(
                        runningSum + currNumber,
                        digit,
                        target,
                        representation,
                        index+1);
    }

    // get all punishing numbers less than the given limit
    public Integer[] getPunishingNumbers(int n){
        List<Integer> ls = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(isPunishingNumber(i)) ls.add(i);
        }
        return ls.toArray(new Integer[0]);
    }

    // get cumulative squares for a list of numbers
    public Integer[] getCumulativeSquares(Integer[] punishingNumbers){
        int size = punishingNumbers.length;
        Integer[] cummulativeSquares = new Integer[size];
        int sum = 0;
        for(int i = 0; i < size; i++){
            int currNumber = punishingNumbers[i];
            sum += currNumber * currNumber;
            cummulativeSquares[i] = sum;
        }
        return cummulativeSquares;
    }

    // helper method to print the punishing numbers and their cumulative squares
    public void printArrays(int n){
        Integer[] punishingNumbers = getPunishingNumbers(n);
        System.out.println(Arrays.toString(punishingNumbers));
        Integer[] cumulativeSquares = getCumulativeSquares(punishingNumbers);
        System.out.println(Arrays.toString(cumulativeSquares));
    }

    public static void main(String[] args) {
        PunishmentNumber_2698 sol = new PunishmentNumber_2698();
        int sum = 0;
        for(int i = 1; i < 1000; i++){
            sum += i*i;
        }
        System.out.println(sum);
        System.out.println(sol.punishmentNumber(37));
    }
}
