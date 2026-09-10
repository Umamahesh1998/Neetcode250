package org.rohit_sheet.arrays;

/**
 * Given an array of integers arr[]. You have to find the Inversion Count of the array. Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = [2, 4, 1, 3, 5]
 * Output: 3
 * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
public class CountInversion {

    /**
     * we use mergesort to solve this problem
     */
    public int inversionCount(int arr[]) {
        // code here
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return 0;
        int mid = low + (high - low) / 2;
        int count = 0;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    private int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0, count = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= high)
            temp[k++] = arr[j++];
        for (int l = low; l <= high; l++) {
            arr[l] = temp[l - low];
        }
        return count;
    }
}
