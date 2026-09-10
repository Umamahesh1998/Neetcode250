package org.ps2.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array.
 * The window slides one position to the right until it reaches the right edge of the array.
 * Return a list that contains the maximum element in the window at each step.
 * Example 1:
 * Input: nums = [1,2,1,0,4,2,6], k = 3
 * Output: [2,2,4,4,6]
 */
public class SlidingWindowMaximum_239_4 {
    /**
     * Window lopala max/min efficiently track cheyadaniki simple variable saripodu —
     * Deque (monotonic queue, decreasing/increasing order lo maintain chestham) vadi,
     * window slide ayye kొద్దీ max/min O(1) amortized lo update avutundi.
     * we will use one deque and store index inside it
     * when ever we find index that is <=i-k we will remove it
     * when ever we found element that is nums[peek.last()]<nums[i] --> we will remove it
     * we will store the element at last
     * when i>=k-1 --> we will store that nums[deque.peekfirst()] in ans array at idx
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        // Total windows = len - k + 1
        int[] ans = new int[len - k + 1];

        // Deque lo values kaadu, indexes store chestam.
        // Front lo current window lo maximum value index untundi.
        Deque<Integer> queue = new ArrayDeque<>();

        int idx = 0;

        for (int i = 0; i < len; i++) {

            // Current window ki bayata unna old index ni remove cheyyali.
            // i-k kanna chinna/equal index current window lo undadu.
            while (!queue.isEmpty() && queue.peekFirst() <= i - k)
                queue.pollFirst();

            // Current element kanna smaller elements future lo maximum
            // avvalevu, so deque back nunchi remove chestam.
            // Deque ni decreasing order lo maintain cheyyadaniki idi important.
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();

            // Current element index ni deque lo add chestam.
            queue.offerLast(i);

            // First complete window vachinappudu maximum ni answer lo add chestam.
            // Deque front lo always current window maximum index untundi.
            if (i >= k - 1)
                ans[idx++] = nums[queue.peekFirst()];
        }

        return ans;
    }
}
