package org.rohit_sheet.arrays;

/*
You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].

Examples:

Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
 */
public class KandaneAlgo {
    public static void main(String[] args) {


    }

    int maxSubarraySum(int[] arr) {
        // Code here
        int max = arr[0], res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max + arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
