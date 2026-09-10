package org.ps2.arrays_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 * Return the answer with the smaller index first.
 * Example 1:
 * Input:
 * nums = [3,4,5,6], target = 7
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
 */
public class TwoSum_1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem))
                return new int[]{map.get(rem), i};

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
