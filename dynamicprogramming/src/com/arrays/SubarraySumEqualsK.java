package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // idea is to go through the array and try to register the cumulative sum till that index and how many times
    //we have seen it.
    //at each index just check what is difference of currentCumulative sum and sum we want, if that difference
    //already exists in map means we have that element k steps back in array . from that element to the current element
    //sum = k, increment the count
    public static int getSubArraySumKON(int nums[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int totalSubArrays = 0;
        int cumulativeSumatIndex = 0;
        for (int i : nums) {
            cumulativeSumatIndex += i;
            if (map.containsKey(cumulativeSumatIndex - k))
                //get the frequency count at last index which will tell how many times that index was seen
                totalSubArrays += map.get(cumulativeSumatIndex - k);
            map.put(cumulativeSumatIndex, map.getOrDefault(cumulativeSumatIndex, 0) + 1);

        }
        return totalSubArrays;
    }


    public static int getSubArraySumKBruteForce(int nums[], int k) {
        int output = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                if (sum == k)
                    output++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 4, 3, 6, 1, 9};
        int k = 10;
        System.out.println("No of subarrays having sum =" + k + " are " + getSubArraySumKBruteForce(nums, k));
        System.out.println("No of subarrays having sum =" + k + " are " + getSubArraySumKON(nums, k));

    }
}
