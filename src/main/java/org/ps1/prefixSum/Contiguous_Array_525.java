package org.ps1.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class Contiguous_Array_525 {
    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                prefix--;
            else
                prefix++;

            if (map.containsKey(prefix))
                max = Math.max(max, i - map.get(prefix));
            else
                map.put(prefix, i);
        }
        return max;
    }
}
