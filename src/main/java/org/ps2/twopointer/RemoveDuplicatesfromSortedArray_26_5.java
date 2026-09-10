package org.ps2.twopointer;

/**
 * You are given an integer array nums sorted in non-decreasing order. Your task is to remove duplicates from nums in-place so that each element appears only once.
 * <p>
 * After removing the duplicates, return the number of unique elements, denoted as k, such that the first k elements of nums contain the unique elements.
 */
public class RemoveDuplicatesfromSortedArray_26_5 {
    public static void main(String[] args) {

    }

    /**
     * we use twopointer partition/inplace replacement varient to solve this problem
     * we will use two pointers here one for writing and other for reading
     * we will run loop from read=1-->nums.lenght
     * if nums[read] != nums[read-1] --> we will place the nums[read] at nums[write] and append the write
     * return write
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write++] = nums[read];
            }
        }
        return write;
    }
}
