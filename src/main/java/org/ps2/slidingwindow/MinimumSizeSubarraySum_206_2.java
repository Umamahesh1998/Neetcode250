package org.ps2.slidingwindow;

/**
 * You are given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * Example 1:
 * Input: target = 10, nums = [2,1,5,1,5,3]
 * Output: 3
 */
public class MinimumSizeSubarraySum_206_2 {
    /**
     * mana target ki match avey minimum lenght vunde subarra identfy chesi dani length return cheyali
     * we will create 3 variables left, sum, minlen
     * loop run chestam from 0-->nums.length
     * we will calculate the sum --> when ever the "sum >= target" reaches
     * we will compare the current len vs minlen using minlen=Math.min(minlen,right-left+1)
     * we will sub nums[left] from sum
     * we will return the minlen
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE, left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minlen = Math.min(minlen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}
