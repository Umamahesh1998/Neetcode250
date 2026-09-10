package org.ps2.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * Example 1:
 * Input: arr = [2,4,5,8], k = 2, x = 6
 * Output: [4,5]
 */
public class FindKClosestElements_658_1_BS {
    public static void main(String[] args) {

    }

    /**
     * basic ga we need k elements that are very close to x
     * so here we will use the binary search to identify the starting point of that window
     * here we will use "x - arr[mid] > arr[mid+k] - x" --> means
     * current window left side elements kante next window right side elements better ah ani seatch chestaam
     * after finding the starting point we will store k elements from that starting point
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
