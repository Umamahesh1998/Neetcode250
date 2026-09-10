package org.ps2.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
 * Return the area of the largest rectangle that can be formed among the bars.
 * Input: heights = [7,1,7,2,2,4]
 * Output: 8
 */
public class LargestRectangleinHistogram_84_2 {
    /**
     * We need to find the largest rectangle that can be formed
     * using consecutive histogram bars.
     *
     * Idea:
     * - Use stack to store indices of bars.
     * - Stack will maintain bars in increasing height order.
     * - When we find a smaller bar, we know that the taller bar
     *   cannot extend further to the right.
     * - So we calculate the rectangle area for that taller bar.
     */
    public int largestRectangleArea(int[] heights) {

        // Step 1:
        // Store indices of bars in increasing height order.
        Deque<Integer> stack = new ArrayDeque<>();

        // Step 2:
        // Keep track of the maximum area found so far.
        int maxArea = 0;

        // Step 3:
        // Traverse all bars.
        //
        // i <= heights.length is intentional.
        // At i == heights.length, we consider currentHeight = 0
        // so that all remaining bars in the stack are processed.
        for (int i = 0; i <= heights.length; i++) {

            // Step 4:
            // For the last iteration, use height 0 as a sentinel.
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            // Step 5:
            // If current bar is smaller than the bar at stack top,
            // that taller bar's rectangle must end before current bar.
            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {

                // Step 6:
                // Remove the taller bar from stack.
                // This is the height of the rectangle we are calculating.
                int height = heights[stack.pop()];

                // Step 7:
                // Find the left boundary.
                //
                // After popping:
                // stack.peek() = nearest smaller bar on the left.
                //
                // If stack is empty, there is no smaller bar on left,
                // so we use -1.
                int left = stack.isEmpty() ? -1 : stack.peek();

                // Step 8:
                // Calculate width.
                //
                // Rectangle can extend:
                // from left + 1
                // to i - 1
                //
                // Therefore:
                // width = i - left - 1
                int width = i - left - 1;

                // Step 9:
                // Calculate area.
                int area = width * height;

                // Step 10:
                // Update maximum area.
                maxArea = Math.max(area, maxArea);
            }

            // Step 11:
            // Add current index to stack.
            stack.push(i);
        }

        // Step 12:
        // Return the largest rectangle area.
        return maxArea;
    }
}
