package com.wackstr.leetcode;

/*
2025-03-04
 */
public class PowerOfThree_1780 {
    public boolean checkPowersOfThree(int n) {
        int achieved = Math.max(
                trySum(1, 1, n),
                trySum(0, 1, n));
        return achieved == 1;
    }

    private int trySum(int currSum, int nextPower, int n) {
        if(currSum == n) return 1;
        int nextNum = (int) Math.pow(3, nextPower);
        if(currSum + nextNum > n) return 0;
        nextPower++;
        return Math.max(
                trySum(currSum, nextPower, n),
                trySum(currSum + nextNum, nextPower, n)
        );
    }

    /*
    since 3^(n+1) is greater than sum of all powers of n before it,
    work in reverse. if subtracting a term leaves a number larger than
    the current power, we cannot use each power once.
     */
    public boolean CheckPowersOfThree_reverse(int n){
        int power = 0;

        // Find the largest power that is smaller or equal to n
        while (Math.pow(3, power) <= n) {
            power++;
        }

        while (n > 0) {
            // Subtract current power from n
            if (n >= Math.pow(3, power)) {
                n -= (int) Math.pow(3, power);
            }
            // We cannot use the same power twice
            if (n >= Math.pow(3, power)) {
                return false;
            }
            // Move to the next lower power
            power--;
        }

        // n has reached 0
        return true;
    }

    /*
    ternary representation, if remainder is 2 at any point, we have to use
    that power more than once
     */
    public boolean checkPowersOfThree_ternary(int n){
        while (n > 0) {
            // Check if this power should be used twice
            if (n % 3 == 2) {
                return false;
            }
            // Divide n by 3 to move to the next greater power
            n /= 3;
        }
        // The ternary representation of n consists only of 0s and 1s
        return true;
    }

    public static void main(String[] args) {
        int n = 12;
        PowerOfThree_1780 sol = new PowerOfThree_1780();
        System.out.println(sol.checkPowersOfThree(n));
    }
}
