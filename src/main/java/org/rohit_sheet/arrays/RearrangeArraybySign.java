package org.rohit_sheet.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array arr[] of size n, the task is to rearrange it in alternate positive and negative manner without changing the relative order of positive and negative numbers. In case of extra positive/negative numbers, they appear at the end of the array.
 * Note: The rearranged array should start with a positive number and 0 (zero) should be considered as a positive number.
 * Examples:
 * Input:  arr[] = [1, 2, 3, -4, -1, 4]
 * Output: arr[] = [1, -4, 2, -1, 3, 4]
 */
public class RearrangeArraybySign {
    public static void main(String[] args) {

    }

    static void rearrange(int[] arr) {
        List<Integer> posi = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int n : arr) {
            if (n > 0)
                posi.add(n);
            else
                neg.add(n);
        }
        int idx = 0, pidx = 0, nidx = 0;
        while (pidx < posi.size() && nidx < neg.size()) {
            arr[idx++] = posi.get(pidx++);
            arr[idx++] = neg.get(nidx++);
        }
        while (pidx < posi.size())
            arr[idx++] = posi.get(pidx++);
        while (nidx < neg.size())
            arr[idx++] = neg.get(nidx++);


    }
}
