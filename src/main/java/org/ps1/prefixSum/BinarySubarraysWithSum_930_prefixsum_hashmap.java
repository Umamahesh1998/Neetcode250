package org.ps1.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum_930_prefixsum_hashmap {
    public static void main(String[] args) {

    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0, count = 0;
        for (int n : nums) {
            prefix += n;
            count += map.getOrDefault(prefix - goal, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
