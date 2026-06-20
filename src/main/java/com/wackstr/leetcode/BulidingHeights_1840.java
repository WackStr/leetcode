package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
2026-06-20 1840
 */
public class BulidingHeights_1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        // Convert the constraints to a list for manipulation
        List<int[]> r = new ArrayList<>();
        for (int[] res : restrictions) {
            r.add(new int[] { res[0], res[1] });
        }

        // Add restriction (1, 0)
        r.add(new int[] { 1, 0 });
        // Sort by position
        r.sort(Comparator.comparingInt(a -> a[0]));
        // Add restriction (n, n-1)
        if (r.get(r.size() - 1)[0] != n) {
            r.add(new int[] { n, n - 1 });
        }

        int m = r.size();

        // Pass restrictions from left to right
        for (int i = 1; i < m; ++i) {
            int dist = r.get(i)[0] - r.get(i - 1)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i - 1)[1] + dist);
        }

        // Pass restrictions from right to left
        for (int i = m - 2; i >= 0; --i) {
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i + 1)[1] + dist);
        }

        int ans = 0;
        for (int i = 0; i < m - 1; ++i) {
            // Calculate the maximum height of the buildings between r[i][0] and r[i][1]
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            int best = (dist + r.get(i)[1] + r.get(i + 1)[1]) / 2;
            ans = Math.max(ans, best);
        }

        return ans;
    }
}
