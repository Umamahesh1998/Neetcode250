package org.ps1.SlidingWindow;

import java.util.*;

/*

 */
public class SlidingWindowMaximum_239_4 {
    public static void main(String[] args) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7}, k = 3, idx = 0;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.offerLast(i);

            if (i >= k - 1)
                ans[idx++] = nums[dq.peekFirst()];
        }
        return ans;

    }

    public static int[] maxSlidingWindowBF(int[] nums, int k) {
        int left = 0;
        List<Integer> list = new ArrayList<>();
        for (int right = k - 1; right < nums.length; right++) {
            list.add(Arrays.stream(Arrays.copyOfRange(nums, left, right + 1)).max().getAsInt());
            left++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
