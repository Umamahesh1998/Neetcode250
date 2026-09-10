package org.rohit_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.
 * Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.
 * Examples:
 * Input: arr = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, 1]]
 * Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
 * arr[2] + arr[4] = 1 + (-1) = 0.
 * The distinct pair are [-1,1].
 */
public class PairWith0Sums {
    public static void main(String[] args) {

    }

    /**
     * SOrt+two pointer approach
     */
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        int left = 0, right = arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                ans.add((ArrayList<Integer>) Arrays.asList(arr[left], arr[right]));
                int leftval = arr[left];
                int rightval = arr[right];
                while (left < right && arr[left] == leftval)
                    left++;
                while (left < right && arr[right] == rightval)
                    right--;
            } else if (sum > 0)
                right--;
            else
                right++;
        }
        return ans;

    }
}
