package org.rohit_sheet.arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * The replacement must be in place and use only constant extra memory.
 * Example 1
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 */
public class NextPermutation_31 {

    /**
     * find pivot -> nums[i]<nums[i+1] from right
     * find element greater than pivot from left
     * swap pivot and greater element
     * reverse the right half
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //finding pivot
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        //find bigger element than pivot + swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i && nums[i] >= nums[j])
                j--;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        //reverse remaining half
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
