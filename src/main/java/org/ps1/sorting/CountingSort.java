package org.ps1.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        countingSortWithPrefix(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] arr) {
        //find max element
        int max = arr[0];
        for (int num : arr)
            max = Math.max(max, num);

        //create counting array
        int[] counting = new int[max + 1];

        //count frequency
        for (int num : arr)
            counting[num]++;

        //reconstruct sorted array
        int index = 0;
        for (int i = 0; i < counting.length; i++) {
            while (counting[i] > 0) {
                arr[index++] = i;
                counting[i]--;
            }
        }
    }

    public static void countingSortWithPrefix(int[] arr) {
        int max = arr[0];
        for (int num : arr)
            max = Math.max(max, num);

        int[] counting = new int[max + 1];
        //count frequency
        for (int num : arr)
            counting[num]++;

        //prefix sum
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        //output array
        int[] output = new int[arr.length];

        //traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            output[counting[arr[i]] - 1] = arr[i];
            counting[arr[i]]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
