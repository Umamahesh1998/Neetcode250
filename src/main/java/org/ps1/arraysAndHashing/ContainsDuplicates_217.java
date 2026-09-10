package org.ps1.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: nums = [1,2,3,1]
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * The element 1 occurs at the indices 0 and 3.
 */
public class ContainsDuplicates_217 {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n))
                return false;
        }
        return true;
    }
}
