package org.rohit_sheet.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * You are given two arrays a[] and b[], return the Union of both the arrays in any order.
 * <p>
 * The Union of two arrays is a collection of all distinct elements present in either of the arrays. If an element appears more than once in one or both arrays, it should be included only once in the result.
 * <p>
 * Note: Elements of a[] and b[] are not necessarily distinct.
 * Note that, You can return the Union in any order but the driver code will print the result in sorted order only.
 * <p>
 * Examples:
 * <p>
 * Input: a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
 * Output: [1, 2, 3]
 * Explanation: Union set of both the arrays will be 1, 2 and 3.
 */
public class UnionOfArrayWithDuplicate {
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 2, 1}, b[] = new int[]{3, 2, 2, 3, 3, 2};
    }

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {

        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int n : a) {
            if (set.add(n)) {
                list.add(n);
            }
        }

        for (int n : b) {
            if (set.add(n)) {
                list.add(n);
            }
        }

        return list;
    }
}
