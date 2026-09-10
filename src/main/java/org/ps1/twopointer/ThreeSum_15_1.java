package org.ps1.twopointer;

/***
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intution
 * fixed point + two sum II
 */
public class ThreeSum_15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        Arrays.sort(nums);
        for (int fixed = 0; fixed < nums.length - 2; fixed++) {
            if (fixed > 0 && nums[fixed] == nums[fixed - 1]) {
                continue;
            }
            int left = fixed + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[fixed] + nums[right] + nums[left];
                if (sum == 0) {
                    output.add(Arrays.asList(nums[fixed], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return output;

    }
}
