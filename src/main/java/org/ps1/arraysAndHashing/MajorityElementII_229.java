package org.ps1.arraysAndHashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 */
public class MajorityElementII_229 {
    public static void main(String[] args) {

    }

    //we use boyer voore extended algorithm
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (candidate1 == num)
                count1++;
            else if (candidate2 == num)
                count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        //varify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        List<Integer> ans = new ArrayList<>();
        if (count1 > nums.length / 3)
            ans.add(candidate1);
        if (count2 > nums.length / 3)
            ans.add(candidate2);

        return ans;
    }
}
