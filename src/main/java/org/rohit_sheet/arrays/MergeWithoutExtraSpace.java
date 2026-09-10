package org.rohit_sheet.arrays;

import java.util.Arrays;

/**
 * Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.
 * <p>
 * Examples:
 * Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
 * Output: a[] = [2, 2, 3, 4], b[] = [7, 10]
 * Explanation: After merging the two non-decreasing arrays, we get, [2, 2, 3, 4, 7, 10]
 */
public class MergeWithoutExtraSpace {
    public void mergeArrays(int a[], int b[]) {
        // code here
        int i = 0, j = 0, k = a.length - 1;
        while (i <= k && j < b.length) {
            if (a[i] < b[j])
                i++;
            else {
                swap(a, b, k, j);
                k--;
                j++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    private void swap(int[] a, int[] b, int k, int j) {
        int temp = a[k];
        a[k] = b[j];
        b[j] = temp;
    }

}
