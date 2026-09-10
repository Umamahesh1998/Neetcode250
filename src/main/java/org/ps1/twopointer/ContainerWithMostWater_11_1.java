package org.ps1.twopointer;

public class ContainerWithMostWater_11_1 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {

        if (height.length == 1)
            return 1;

        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int area = (right - left) * (Math.min(height[left], height[right]));
            max = Math.max(area, max);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
