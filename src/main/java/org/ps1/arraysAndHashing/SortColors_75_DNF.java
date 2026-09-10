package org.ps1.arraysAndHashing;

public class SortColors_75_DNF {
    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 1});
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1)
                mid++;
            else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
