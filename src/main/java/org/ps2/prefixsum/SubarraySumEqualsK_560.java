package org.ps2.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * Example 1:
 * Input: nums = [2,-1,1,2], k = 2
 * Output: 4
 */
public class SubarraySumEqualsK_560 {
    public static void main(String[] args) {

    }

    /**
     * prefix sum use chestam and we will store the count no of times ah prefix sum vachinadi
     * we will check for every prefixsum mana map lo prefix-k value vunda ani check chestam
     * if it present then we will append the count
     * manam map lo store chestam prefix,map.getOrDefault(prefix,0)+1
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, prefix = 0;
        for (int n : nums) {
            prefix += n;
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
