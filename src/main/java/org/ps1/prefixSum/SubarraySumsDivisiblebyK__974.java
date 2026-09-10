package org.ps1.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK__974 {
    public static void main(String[] args) {
        int nums[] = {4, 5, 0, -2, -3, 1}, k = 5;

    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, prefix = 0;
        for (int num : nums) {
            prefix += num;
            int rem = ((prefix % k) + k) % k;
            count += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
