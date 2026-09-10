package org.ps2.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 * A substring is a contiguous sequence of characters within a string.
 * Example 1:
 * Input: s = "zxyzxyz"
 * Output: 3
 */
public class LongestSubstringWithoutRepeatingCharacters_3_2 {
    /**
     * we will use sliding window varient 2 approach where the window size is not fixed it will change based on the situation
     * initial ga we will create 2 variables and 1 set
     * we will run a loop across the string len
     * if character is present in the set  we will remove it from the left side then we will add it in right side
     * we will calculate the max lenght
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
