package com.wackstr.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
2025-07-18
 */
public class MaxDifference_2163 {
    public long minimumDifference(int[] nums){

        /*
        to get min(sum_first - sum_second), we need to minimize sum_first
        and maximize sum_second

        let range = n/3

        For our answer, assume sum_first ends at index i. We will take the
        minimum sum of range elements from left ending on nums[i] and the
        maximum sum of range elements ending from right ending on nums[i + 1]

        This suggests we track minimum sums of range elements from left to
        right and maximum sum of range elements from right to left.

        However, we don't need to do these for all indexes. We only need to
        track range + 1 min and max sums.

        To understand this, see that the left sum of range elements will start
        on nums[range - 1] and the first sum of range elements from right will
        end at nums[n - range]. So the maximum sums possible on left without
        reducing the numbers available on the right to less than range are:

        (n - range - (range - 1)) = (n - range - range + 1)
        = (n - 2range + 1) = n - 2n/3 + 1= n/3 + 1 = range + 1

        For any index where left(inclusive) and right(exclusive) sections have
        at least range numbers, we subtract the maximum sum on right from
        minimum sum on left and track the minimum value for all possible
        indexes.

        If we can track min/max sums in O(1) - through queues - we can
        solve this efficiently by tracking minimum of minSums[i] - maxSums[i].


        here minSums and maxSums are arrays tracking sums as defined above
         */

        /*
        count variables
        we will track min sums from left up to this index (exclusively)
         */
        int n = nums.length;
        int range = n/3;
        int rightCutoff = n - range;

        long currSum = 0; // for tracking min or maximum

        /*
         minSum[i]:
            minimum Sum of range elements from left to right up to index
            nums[range + i - 1]
         maxSums[i]:
            maximum Sum of range elements from right to left up to index
            nums[range + i]

        The way these arrays are set up you can see that if we look at
        minSums[i], then we will compare to maxSums[i] for the
        minimum difference
         */
        long[] minSums = new long[range + 1]; //
        long[] maxSums = new long[range + 1]; //

        // these will help build the minSum and maxSums
        Queue<Integer> maxQueue =
                new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> minQueue = new PriorityQueue<>();

        long minDiff; // final return value


        // populate maxSums
        for (int i = 0; i < range; i++) {
            maxQueue.offer(nums[i]);
            currSum += nums[i];
        }

        minSums[0] = currSum;
        for(int i = range; i < rightCutoff; i++){
            if(nums[i] < maxQueue.peek()){
                currSum += nums[i] - maxQueue.poll();
                maxQueue.offer(nums[i]);
            }
            minSums[i - range + 1] = currSum;
        }


        // populate minSums - and track minDiff since we have maxSums
        currSum = 0;
        for(int i = n - 1; i >= n - range; i--){
            currSum += nums[i];
            minQueue.offer(nums[i]);
        }
        maxSums[range] = currSum;

        // initialize minDiff
        minDiff = minSums[range] - maxSums[range];

        // track minDiff as we complete filling on minSums
        for (int i = 1; i <= range; i++) {
            int num = nums[n - range - i];
            if(num > minQueue.peek()){
                currSum += num - minQueue.poll();
                minQueue.offer(num);
            }
            maxSums[range - i] = currSum;
            minDiff = Math.min(minDiff,
                    minSums[range - i] - maxSums[range - i]);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        MaxDifference_2163 sol = new MaxDifference_2163();
        System.out.println(sol.minimumDifference(nums));
    }
}
