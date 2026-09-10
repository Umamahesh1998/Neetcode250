package org.ps1.SlidingWindow;

/**
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
public class MinimumWindowSubstring_76_3 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int[] need = new int[128];
        int[] window = new int[128];
        int required = 0, formed = 0, left = 0, start = 0, minLen = Integer.MAX_VALUE;

        for (char c : t.toCharArray())
            need[c]++;

        for (int count : need)
            if (count > 0)
                required++;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window[ch]++;
            if (need[ch] > 0 && need[ch] == window[ch])
                formed++;

            //if formed == required we need to shrink the window without losing the formed
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char remove = s.charAt(left);
                window[remove]--;
                if (need[remove] > 0 && need[remove] > window[remove])
                    formed--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
