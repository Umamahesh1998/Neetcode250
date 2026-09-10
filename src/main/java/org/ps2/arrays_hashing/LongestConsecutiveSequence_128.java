package org.ps2.arrays_hashing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
 * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
 * Input: nums = [2,20,4,10,3,4,5]
 * Output: 4
 */
public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {

    }

    /**
     * so basically we need to identify the continuous elements
     * inital ga we will put all the elements in one set
     * we will check if the num-1 is present in set if it is not present then it is the starting point
     * we will run a loop now set contains num+1 --> we will increase the count
     * once we come out of loop we will update the maxcount and return it
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        int max = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int len = 1;
                while (set.contains(n + len)) {
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
