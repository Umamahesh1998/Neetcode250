package org.ps1.twopointer;

/**
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray_189_7 {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        rotate(nums, 0, nums.length - 1);
        rotate(nums,0,k-1);
        rotate(nums,k,nums.length-1);
    }

    private static void rotate(int[] nums, int left, int right) {
        while (left < right) {
            int num = nums[left];
            nums[left] = nums[right];
            nums[right] = num;
            left++;
            right--;
        }
    }
}
