package org.ps2.twopointer;

/**
 * You are given an array of non-negative integers height which represent an elevation map.
 * Each value height[i] represents the height of a bar, which has a width of 1.
 * Return the total amount of water that can be trapped between the bars.
 * Example 1:
 * Input: height = [0,2,0,3,1,0,1,3,2,1]
 * Output: 9
 */
public class TrappingRainWater_42_1_Hard {
    public static void main(String[] args) {

    }

    /**
     * we use two pointer approach here to solve this problem
     * left, right pointer madhya loop run chestam
     * we will identify the leftmax value and rightmax value -->
     * then we will subtract this max valuw with height[left] or height[right] then add it to water
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right--];
            }
        }
        return water;
    }
}
