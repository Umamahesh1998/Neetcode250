package org.ps2.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array nums of size n, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * Note: [1,0,3,2] and [3,0,1,2] are considered as same quadruplets.
 * Example 1:
 * Input: nums = [3,2,3,-3,1,0], target = 3
 */
public class FourSum_18_1 {
    public static void main(String[] args) {

    }

    /**
     * idi same as 3sum problem but here instead of 2+1 fixed we use 2+2fixed pointer
     * sort the array
     * fourth pointer i=0-->nums.length-3
     * third pointer j=i+1-->nums.lenght-2
     * second pointer left=j+1
     * first pointer right=nums.length-1;
     * every pointer ki we will skip the duplicates by checking it before entering main step
     * if we found nums[a] + nums[b] + nums[c] + nums[d] == target --> we will send those values in output
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int fourth = 0; fourth < nums.length - 3; fourth++) {
            if (fourth > 0 && nums[fourth] == nums[fourth - 1])
                continue;
            for (int third = fourth + 1; third < nums.length - 2; third++) {
                if (third > fourth + 1 && nums[third] == nums[third - 1])
                    continue;
                int second = nums.length - 1, first = third + 1;
                while (first < second) {
                    long sum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        output.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        first++;
                        second--;
                        while (first < second && nums[first] == nums[first - 1])
                            first++;
                        while (first < second && nums[second] == nums[second + 1])
                            second--;
                    } else if (sum > target)
                        second--;
                    else
                        first++;
                }
            }
        }
        return output;
    }
}
