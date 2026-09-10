package org.ps2.twopointer;

/**
 * Given an array of integers numbers that is sorted in non-decreasing order.
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2.
 * Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 * There will always be exactly one valid solution.
 * Your solution must use 0(1)
 * O(1) additional space.
 * Example 1:
 * Input: numbers = [1,2,3,4], target = 3
 * Output: [1,2]
 */
public class TwoSumII_InputArrayIsSorted_167_1 {
    public static void main(String[] args) {

    }

    /**
     * Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
     * manam two pointer approach use chestam --> left=0, right=numbers.length-1;
     * we will rn the pointer
     * scenario1: if(nums[left]+nums[right]==target) --> return left,right
     * scenario2: if(nums[left]+nums[right]>target) --> right-- else left++
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left+1, right+1};
            else if (sum > target)
                right--;
            else
                left++;
        }
        return new int[]{};
    }
}
