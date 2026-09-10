package org.ps2.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums of size n, find all elements that appear more than ⌊ n/3 ⌋ times. You can return the result in any order.
 * Example 1:
 * Input: nums = [5,2,3,2,2,2,2,5,5,5]
 * Output: [2,5]
 */
public class MajorityElementII_229 {
    public static void main(String[] args) {

    }

    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0, cand2 = 0, count1 = 0, count2 = 0, nl = nums.length;
        for (int n : nums) {
            if (n == cand1)
                count1++;
            else if (n == cand2)
                count2++;
            else if (count1 == 0) {
                cand1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = n;
                count2 = 0;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (cand1 == n)
                count1++;
            if (cand2 == n)
                count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (count1 > (nl / 3))
            ans.add(cand1);
        if (count2 > (nl / 3))
            ans.add(cand2);

        return ans;
    }

}
