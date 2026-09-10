package org.ps2.arrays_hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 * The test cases are generated such that the answer is always unique.
 * You may return the output in any order.
 * Example 1:
 * Input: nums = [1,2,2,3,3,3], k = 2
 * Output: [2,3]
 */
public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3}, k = 2;
        topKFrequent(nums, k);
    }

    /**
     * element frequency ni hashmap lo store chestam
     * we will create a priority queue elements will be prioritize based on value
     * when ever the queue size crosses k we will pop the element
     * now we will create a array of size k and insert the elements present in queue
     * we will insert elements into ans array in reverse order to maintain order
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (var en : map.entrySet()) {
            pq.offer(en);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
