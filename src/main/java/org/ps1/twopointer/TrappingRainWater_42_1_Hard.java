package org.ps1.twopointer;

public class TrappingRainWater_42_1_Hard {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, water = 0, left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
