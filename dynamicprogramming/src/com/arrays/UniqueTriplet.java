package com.arrays;

import java.util.*;

public class UniqueTriplet {
    /*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

    Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int element = nums[i];
            while (low < high) {
                int eleSum = element + nums[low] + nums[high];
                if (eleSum == 0) {
                    List<Integer> temp = Arrays.asList(element, nums[low], nums[high]);
                    if (!out.contains(temp)) {
                        out.add(temp);
                        low++;
                        high--;
                    }
                } else if (eleSum < 0)
                    low++;
                else
                    high--;
            }
        }
        return out;
    }


    public static void main(String[] args) {
        //[-2,0,1,1,2]
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
