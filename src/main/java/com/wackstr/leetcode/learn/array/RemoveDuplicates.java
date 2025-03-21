package com.wackstr.leetcode.learn.array;

import java.util.Arrays;

public class RemoveDuplicates {

    /*
    whenever we see a duplicate, "delete" it.
    Move each element ahead of it to right and decrement total length
     */
    public int removeDuplicates(int[] nums) {

        // The initial length is simply the capacity.
        int length = nums.length;

        // Assume the last element is always unique.
        // Then for each element, delete it if it is
        // the same as the one after it. Use our deletion
        // algorithm for deleting from any index.
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                // Delete the element at index i, using our standard
                // deletion algorithm we learned.
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                // Reduce the length by 1.
                length--;
            }
        }
        // Return the new length.
        return length;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicates sol = new RemoveDuplicates();
        System.out.println(sol.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

    }
}
