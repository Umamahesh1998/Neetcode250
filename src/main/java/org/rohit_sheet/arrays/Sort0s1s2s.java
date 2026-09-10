package org.rohit_sheet.arrays;

/**
 * Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 * Note: You need to solve this problem without utilizing the built-in sort function.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = [0, 1, 2, 0, 1, 2]
 * Output: [0, 0, 1, 1, 2, 2]
 * Explanation: 0s, 1s and 2s are segregated into ascending order.
 */
public class Sort0s1s2s {
    public static void main(String[] args) {

    }

    public void sort012(int[] arr) {
        int mid = 0, low = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1)
                mid++;
            else if (arr[mid] == 2) {
                swap(arr, mid, high);
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
