package org.ps1.arraysAndHashing;

import java.util.Map;
import java.util.TreeMap;

/**
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement_169 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int n : nums) {
            if (count == 0)
                candidate = n;

            if(candidate==n)
                count++;
            else
                count--;
        }
        if(count>nums.length/2)
            return candidate;
        throw new IllegalArgumentException("not an majority element");
    }
}
