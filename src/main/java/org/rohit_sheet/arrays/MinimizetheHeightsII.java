package org.rohit_sheet.arrays;

import java.util.Arrays;

/**
 * Given an array arr[] representing the heights of n towers and a positive integer k. For each tower, perform exactly one of the following operations exactly once:
 * Increase its height by k, or
 * Decrease its height by k.
 * After performing the operation on every tower, the height of any tower must not become negative.
 * Return the minimum possible difference between the heights of the tallest and the shortest towers after modifying all the towers.
 * Note: A slight modification of the problem can be found here.
 * Examples :
 * Input: k = 2, arr[] = [1, 5, 8, 10]
 * Output: 5
 * Explanation: The array can be modified as [1+k, 5-k, 8-k, 10-k] = [3, 3, 6, 8]. The difference between the largest and the smallest is 8-3 = 5.
 */
public class MinimizetheHeightsII {

    /**
     * 1. Array ni sort cheyyali
     * 2. Oka split point pettaali
     * 3. Split varaku → +k
     * 4. Split tarvata → -k
     * 5. Modified values lo → min & max find cheyyali
     * 6. max - min calculate cheyyali
     * 7. Ila every split ki calculate chesi → overall minimum teesukovali
     */
    public int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int ans = arr[n - 1] - arr[0];
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - k < 0)
                continue;
            int min = Math.min(arr[0] + k, arr[i + 1] - k);
            int max = Math.max(arr[i] + k, arr[n - 1] - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
