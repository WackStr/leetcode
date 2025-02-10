package com.wackstr.leetcode;

/*
2024-11-15
 */
public class ShortestSubArrayRemoval_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length - 1;
        while(right > 0 && arr[right] >= arr[right - 1]) right--;
        int ans = right;

        int left = 0;
        while(left < right && (left == 0 || arr[left] >= arr[left - 1])) {
            while (right < arr.length && arr[right] < arr[left]) {
                right++;
            }
            ans = Math.min(ans, right - left - 1);
            left++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {13,0,14,7,18,18,18,16,8,15,20};
        ShortestSubArrayRemoval_1574 sol = new ShortestSubArrayRemoval_1574();
        System.out.println(sol.findLengthOfShortestSubarray(arr));
    }
}
