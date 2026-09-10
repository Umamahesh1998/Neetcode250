package org.ps2.twopointer;

/**
 * You are given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7,8], k = 4
 * Output: [5,6,7,8,1,2,3,4]
 */
public class RotateArray_189_7 {
    public static void main(String[] args) {

    }

    /**
     * ichina array ni right ki rotate cheyali ipudu manam so ela ante
     * [1,2,3,4,5,6,7,8]
     * [5,6,7,8,1,2,3,4]
     * steps:
     * we use two pointers two swap and rotate the elements
     * rotate complete array
     * [8,7,6,5,4,3,2,1]
     * rotate 0-->k-1 part
     * [5,6,7,8,4,3,2,1]
     * rotate k --> nums.lenght
     * [5,6,7,8,1,2,3,4]
     * k ni nums.length tho modulo cheyyali:
     * k = k % nums.length;
     * Because rotate by 7 positions = rotate by 2 positions.
     * 7 % 5 = 2
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    void swap(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
