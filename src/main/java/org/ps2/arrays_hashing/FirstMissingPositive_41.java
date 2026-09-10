package org.ps2.arrays_hashing;

/**
 * You are given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * Example 1:
 * Input: nums = [-2,-1,0]
 * Output: 1
 */
public class FirstMissingPositive_41 {
    public static void main(String[] args) {

    }

    /**
     * we use cyclic sort here, cyclic sort ante elements ni vati correct indeex lo petadaniki use chestam
     * means as our index starts from 0...n if element 1 vuntey adi 0 idx dagara 2 --> 1 idx ala place chestam
     * once after completing the sorting
     * we will check ani elements vunaya ani if no? we will return the missing element else we will return n+1
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //cyclic sort
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctedIdx = nums[i] - 1;
                int temp = nums[correctedIdx];
                nums[correctedIdx] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
