package org.ps2.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 */
public class FindAllAnagramsinaString_438_3 {

    /**
     * Window lopala unna elements ni HashMap tho count/frequency track chestham — window validity simple condition meedha kadu,
     * character-frequency comparison meedha depend avutundi (anagram/permutation match check ki).
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        //p lo each character frequency map lo store chestam
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //current window lo character frequency store chestam
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        // Enni required character frequencies currently match ayyayo count chestam.
        int matched = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            //current character ni window lo add chestam
            window.put(c, window.getOrDefault(c, 0) + 1);
            // Current character required count tho exactly match ayyinda?
            // Example: need[a]=2 and window[a]=2 -> one character condition matched.
            if (window.get(c).equals(need.get(c)))
                matched++;

            // Window size p length kanna ekkuva ayithe,
            // left side character ni remove chesi window size maintain chestam.
            if (right - left + 1 > p.length()) {
                char lc = s.charAt(left);
                // Remove cheyyaboye character currently required count tho
                // match ayyi unte, remove chesaka aa match break avtundi.
                if (window.get(lc).equals(need.get(lc)))
                    matched--;
                // Leftmost character count ni decrease chestam.
                window.put(lc, window.get(lc) - 1);
                // Window ni one position right ki move chestam.
                left++;
            }
            // matched == need.size() ante p lo unna anni distinct characters
            // required frequency tho match ayyayi.
            // Window size already p.length() kabatti idi anagram.
            if (matched == need.size())
                result.add(left);

        }
        return result;
    }
}
