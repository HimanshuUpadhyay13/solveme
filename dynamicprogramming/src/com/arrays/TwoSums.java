package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSums {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> storageMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(storageMap.containsKey(target-nums[i]))
                return new int[]{storageMap.get(target-nums[i]),i};
            else
            storageMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Sum found");
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(TwoSums.twoSum(new int[]{2, 7, 11, 15}, 9)));

    }

}
