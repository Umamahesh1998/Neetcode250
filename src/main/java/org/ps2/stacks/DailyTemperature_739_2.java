package org.ps2.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
 * <p>
 * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
 * <p>
 * Example 1:
 * <p>
 * Input: temperatures = [30,38,30,36,35,40,28]
 * <p>
 * Output: [1,4,1,2,1,0,0]
 */
public class DailyTemperature_739_2 {

    /**
     *
     * we will maintain two fields 1. int[] ans and 2. stack to store index
     * when ever we found the element that is > prev index we will feed the ans array
     * we wll store the index in stack
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;


    }
}
