package com.wackstr.leetcode;

import com.wackstr.leetcode.learn.linkedlist.ListNode;

import java.util.Arrays;

/*
2026-08-31 2058
 */
public class CriticalPointsDistance_2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        int idx = 1;
        int f_idx = -1;
        int l_idx = -1;
        int min_dist = Integer.MAX_VALUE;

        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;
        if(c==null){     // 2 nodes only
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }

        while(c!=null){
            if(b.val<a.val && b.val<c.val || b.val>a.val && b.val>c.val){
                if(f_idx==-1) f_idx = idx;
                if(l_idx!=-1) {
                    int dist = idx - l_idx;
                    min_dist = Math.min(dist,min_dist);
                }
                l_idx = idx;
            }

            idx++;
            a = a.next;
            b = b.next;
            c = c.next;


        }

        int max_dist = l_idx - f_idx;
        if(max_dist == 0)
            max_dist = -1;

        if(min_dist == Integer.MAX_VALUE)
            min_dist = -1;

        ans[0] = min_dist;
        ans[1] = max_dist;

        return ans;

    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{5,3,1,2,5,1,2});
        CriticalPointsDistance_2058 sol = new CriticalPointsDistance_2058();
        System.out.println(Arrays.toString(sol.nodesBetweenCriticalPoints(head)));
    }
}
