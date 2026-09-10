package org.ps2.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0,
 * and the indices i, j and k are all distinct.
 * The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum_15_1 {
    public static void main(String[] args) {

    }

    /**
     * basic ga we need to find an triplets whose sum==0
     * manaki combination array istadu manam every three element sum chesi check cheyali
     * here we will use two pointer approach with extra 1 fixed pointer
     * also we will check if duplicate element is present if yes we will skip that element
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int fixed = 0; fixed < nums.length - 2; fixed++) {
            if (fixed > 0 && nums[fixed] == nums[fixed - 1])
                continue;
            int left = fixed + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[fixed] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[fixed], nums[left], nums[right]));
                    left++;
                    right--;
                    //skip left duplicates
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    //skip right duplicates
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum > 0)
                    right--;
                else
                    left++;
            }
        }
        return ans;
    }
}
