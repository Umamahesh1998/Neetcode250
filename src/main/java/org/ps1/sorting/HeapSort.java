package org.ps1.sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        //build max heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
        System.out.println(Arrays.toString(arr));
        //extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            //move current root to end
            swap(arr, 0, i);
            //heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void heapify(int[] arr, int heapsize, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        //check left child
        if (left < heapsize && arr[left] > arr[largest])
            largest = left;

        //check right child
        if (right < heapsize && arr[right] > arr[largest])
            largest = right;

        //if root is not large swap & continue heapify
        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, heapsize, largest);
        }
    }
}
