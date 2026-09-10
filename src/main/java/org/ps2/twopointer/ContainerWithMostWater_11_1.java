package org.ps2.twopointer;

/***
 * You are given an integer array heights where heights[i] represents the height of the ith bar
 * You may choose any two bars to form a container. Return the maximum amount of water a container can store.
 * Example 1:
 * Input: height = [1,7,2,5,4,7,3,6]
 * Output: 36
 */
public class ContainerWithMostWater_11_1 {
    public static void main(String[] args) {

    }

    /**
     * manaki a container lo ekkuva water padtundi ani check cheyali
     * so basic ga we will calculate the area=l*b (right-left) * Max(heights[left],heights[right])
     * store maxarea
     * if heights[left]<heights[right] --> left++ else right--;
     */
    public int maxArea(int[] heights) {
        if (heights.length == 1)
            return 0;
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, area);
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
