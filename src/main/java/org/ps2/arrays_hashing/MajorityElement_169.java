package org.ps2.arrays_hashing;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times in the array. You may assume that the majority element always exists in the array.
 * Example 1:
 * Input: nums = [5,5,1,1,1,5,5]
 * Output: 5
 */
public class MajorityElement_169 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int candiate = 0, count = 0;
        for (int n : nums) {
            if (count == 0) {
                candiate = n;
            }
            if (candiate == n) {
                count++;
            } else {
                count--;
            }
        }
        return candiate;
    }
}
