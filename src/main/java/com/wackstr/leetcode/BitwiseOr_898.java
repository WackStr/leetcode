package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class BitwiseOr_898 {
    public int subarrayBitwiseORs(int[] arr)
    {
        // Step 1: Initialize list to store OR values
        ArrayList<Integer> s = new ArrayList<>();
        int l = 0; // This marks where the last round of ORs began

        // Step 2: Loop through each number in the array
        for (int a : arr)
        {
            int r = s.size();  // Step 2.1: Store current size of list
            s.add(a);          // Step 2.2: Start a new subarray with just 'a'

            // Step 3: Extend previous OR values with current number
            for (int i = l; i < r; ++i)
            {
                int v = s.get(i) | a;
                if (v != s.get(s.size() - 1))
                {
                    s.add(v);
                }
            }

            // Step 4: Update l to start from new ORs next time
            l = r;
        }

        // Step 5: Use a HashSet to count unique OR values
        return new HashSet<>(s).size();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4};
        BitwiseOr_898 sol = new BitwiseOr_898();
        System.out.println(sol.subarrayBitwiseORs(arr));
    }
}
