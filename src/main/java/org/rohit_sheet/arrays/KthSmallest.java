package org.rohit_sheet.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an integer array arr[] and k. Find the k'th smallest element in the given array.
 * Note: k is always smaller than the size of the array.
 * Examples:
 * Input: arr[] = [10, 5, 4, 3, 48, 6, 2, 33, 53, 10], k = 4
 * Output: 5
 * Explanation: 4th smallest element in the given array is 5.
 */
public class KthSmallest {
    /**
     * we need to identify the kth smallest element and return it
     * we will use prioroty queue here to implement this logic ( Using Max-Heap - O(n * log(k)) Time and O(k) Space)
     */
    public static void main(String[] args) {
        kthSmallest(new int[]{10, 5, 4, 3, 48, 6, 2, 33, 53, 10}, 4);
    }

    public static int kthSmallest(int[] arr, int k) {
        // Create maxheap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : arr) {
            pq.add(n);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}
