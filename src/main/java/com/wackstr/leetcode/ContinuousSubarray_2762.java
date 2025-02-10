package com.wackstr.leetcode;

import java.util.*;

/*
2024-12-14
 */
public class ContinuousSubarray_2762 {

    private static final int RANGE_LIMIT = 2;

    private record Segment(int start, int end) {}

    public long continuousSubarrays(int[] nums){
        Queue<Segment> segments = getSegments(nums);
        return sumSegments(segments);
    }

    private Queue<Segment> getSegments(int[] nums) {
        int left = 0, right = 0;
        TreeMap<Integer, Integer> range = new TreeMap<>();
        Queue<Segment> segments = new ArrayDeque<>();

        while (left < nums.length) {
            while (right < nums.length) {
                range.merge(nums[right], 1, Integer::sum);
                if (exceedsRangeLimit(range)) break;
                right++;
            }

            segments.add(new Segment(left, right - 1));
            if (right >= nums.length) break;

            while (exceedsRangeLimit(range) && left < nums.length) {
                range.computeIfPresent(nums[left], (k, v) -> v == 1 ? null : v - 1);
                left++;
            }

            right++;
        }

        return segments;
    }

    private long sumSegments(Queue<Segment> segments) {
        long cnt = 0;
        int lastMax = -1;
        while(!segments.isEmpty()) {
            Segment seg = segments.poll();
            cnt += countSegment(seg);
            if (lastMax != -1 && lastMax >= seg.start()) {
                cnt -= countSegment(new Segment(seg.start(), lastMax));
            }
            lastMax = seg.end();
        }
        return cnt;
    }

    private long countSegment(Segment seg){
        int length = seg.end() - seg.start() + 1;
        return (long) length * (length + 1) / 2;
    }

    private boolean exceedsRangeLimit(TreeMap<Integer, Integer> range) {
        return range.lastKey() - range.firstKey() > RANGE_LIMIT;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,3,3,2,1,2,2,1};
        ContinuousSubarray_2762 sol = new ContinuousSubarray_2762();
        System.out.println(sol.continuousSubarrays(nums));
    }
}
