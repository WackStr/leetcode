package com.wackstr.leetcode;

/*
2025-05-19
 */
public class TriangleType_3024 {
    public String triangleType(int[] nums){
        if(nums[0] == nums[1] && nums[1] == nums[2]){
            return "equilateral";
        }else{
            int sum = nums[0] + nums[1] + nums[2];
            int max = Math.max(nums[0], Math.max(nums[1], nums[2]));
            if(sum - max <= max) return "none";
            if(nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2])
                return "isosceles";
            return "scalene";
        }
    }

    public static void main(String[] args) {
        TriangleType_3024 sol = new TriangleType_3024();
        System.out.println(sol.triangleType(new int[]{3, 3, 3})); // EQUILATERAL
        System.out.println(sol.triangleType(new int[]{2, 3, 4})); // SCALENE
        System.out.println(sol.triangleType(new int[]{2, 2, 3})); // ISOSCELES
        System.out.println(sol.triangleType(new int[]{1, 2, 3})); // None
    }
}
