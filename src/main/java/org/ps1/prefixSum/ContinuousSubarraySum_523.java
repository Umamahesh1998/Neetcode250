package org.ps1.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_523 {
    public static void main(String[] args) {

    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        maps.put(0, -1);
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            //calculate prefix
            prefix += nums[i];
            int rem = ((prefix % k) + k) % k;
            if (maps.containsKey(rem))
                if (i - maps.get(rem) >= 2)
                    return true;
                else
                    maps.put(rem, 1);
        }
        return false;
    }
}
