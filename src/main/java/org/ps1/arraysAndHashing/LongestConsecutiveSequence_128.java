package org.ps1.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] ip = {100, 4, 200, 1, 3, 2};
    }

    public int longestConsecutive(int[] nums) {
        //create hashset and add those elements
        Set<Integer> hash = new HashSet<>();
        for (int n : nums)
            hash.add(n);
        int longest = 0;
        for (int n : hash) {
            //check n-1 is present in set or not
            if (hash.contains(n - 1)) {
                int len = 1;
                while (hash.contains(n + len))
                    len++;
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}
