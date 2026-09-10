package org.ps1.arraysAndHashing;

import java.util.*;

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3}, k = 2;
        topKFrequent(nums, k);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int n : nums) {
            maps.compute(n, (key, v) -> v == null ? 1 : v + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> m : maps.entrySet()) {
            pq.offer(m);
            if (pq.size() > k)
                pq.poll();
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
