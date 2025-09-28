package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-09-28
 */
public class LargestPerimeter_976 {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for (int i = A.length - 3; i >= 0; --i)
                if (A[i] + A[i+1] > A[i+2])
                    return A[i] + A[i+1] + A[i+2];
            return 0;
        }
}
