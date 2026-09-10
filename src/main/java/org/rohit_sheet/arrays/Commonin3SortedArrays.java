package org.rohit_sheet.arrays;

import java.util.ArrayList;

/**
 * Given three sorted arrays in non-decreasing order, return all common elements in non-decreasing order across these arrays. If there are no such elements return an empty array.
 * Note: Ignore duplicates, include each common element only once in the output.
 * Examples :
 * Input: a[] = [1, 5, 10, 20, 40, 80], b[] = [6, 7, 20, 80, 100], c[] = [3, 4, 15, 20, 30, 70, 80, 120]
 * Output: [20, 80]
 * Explanation: The elements 20 and 80 appear in all three arrays a, b, and c, making them the only common elements, so the output is [20, 80].
 */
public class Commonin3SortedArrays {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        int aRi = a.length, bRi = b.length, cRi = c.length;
        int aLe = 0, bLe = 0, cLe = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (aLe < aRi && bLe < bRi && cLe < cRi) {
            if (a[aLe] == b[bLe] && b[bLe] == c[cLe]) {
                ans.add(a[aLe]);
                //skip duplicates
                int val = a[aLe];
                while (aLe < aRi && a[aLe] == val)
                    aLe++;
                while (bLe < bRi && b[bLe] == val)
                    bLe++;
                while (cLe < cRi && c[cLe] == val)
                    cLe++;
            } else if (a[aLe] < b[bLe])
                aLe++;
            else if (b[bLe] < c[cLe]) {
                bLe++;
            } else
                cLe++;
        }
        return ans;
    }
}
