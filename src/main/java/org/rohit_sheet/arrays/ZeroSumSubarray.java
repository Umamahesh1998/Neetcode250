package org.rohit_sheet.arrays;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, arr[]. Find if there is a subarray (of size at least one) with 0 sum. Return true/false depending upon whether there is a subarray present with 0-sum or not.

Examples:

Input: arr[] = [4, 2, -3, 1, 6]
Output: true
Explanation: 2, -3, 1 is the subarray with a sum of 0.
 */
public class ZeroSumSubarray {
    public static void main(String[] args) {

    }

    /*
        we will use prefixsum+hashset approach
        if same prefix sum again vaste numbers inbetween those indexes ==0 ani consider meaning
        else direct zero vaste e two conditions lo we will send true else false
     */
    public boolean subArrayExists(int arr[]) {
        // code here
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (set.contains(sum) || sum == 0)
                return true;
            set.add(sum);
        }
        return false;
    }
}
