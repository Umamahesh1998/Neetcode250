package org.ps2.arrays_hashing;

/**
 * You are given an array nums consisting of n elements where each element is an integer representing a color:
 * 0 represents red
 * 1 represents white
 * 2 represents blue
 * Your task is to sort the array in-place such that elements of the same color are grouped together and arranged in the order: red (0), white (1), and then blue (2).
 * You must not use any built-in sorting functions to solve this problem.
 * Example 1:
 * Input: nums = [1,0,1,2]
 * Output: [0,1,1,2]
 */
public class SortColors_75 {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
