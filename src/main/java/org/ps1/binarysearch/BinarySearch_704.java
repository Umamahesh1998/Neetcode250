package org.ps1.binarysearch;

public class BinarySearch_704 {
    public static void main(String[] args) {
     int   nums[] = {-1,0,3,5,9,12}, target = 9;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
