package org.ps2.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an integer array nums and an integer k, return true
 * if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k, otherwise return false.
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 */
public class ContainsDuplicateII_219_1 {
    public static void main(String[] args) {

    }

    /**
     * In a given window of size k if we have any duplicate then manam true return cheyali
     * we will store elements in hash set
     * for i=0-->nums.length
     * if set contains element --> return true
     * <p>
     * add elements into the set
     * if set.size()>k --> remove element from left = i-k
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            if (set.contains(nums[right]))
                return true;
            set.add(nums[right]);

            if (set.size() > k) {
                int left = right - k;
                set.remove(nums[left]);
            }
        }
        return false;
    }
}
