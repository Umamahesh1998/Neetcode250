package org.ps1.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560_PrefixSum_HashMap_varient2 {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1}, k = 2;
        subarraySum(nums, k);
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, prefix = 0;
        for (int num : nums) {
            prefix += num;
            if (map.containsKey(prefix - k))
                count += map.get(prefix - k);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        System.out.println(map);
        return count;
    }
}
