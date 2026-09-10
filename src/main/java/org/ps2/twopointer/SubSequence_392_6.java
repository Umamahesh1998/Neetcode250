package org.ps2.twopointer;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 */
public class SubSequence_392_6 {
    public static void main(String[] args) {

    }

    /**
     * manam subsequence find chesi true or false return cheyali
     * so basic ga we have two strings s and t --> we need to check the chars of s should present in t --> if yes true else false
     */
    public boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2))
                p1++;

            p2++;
        }
        return p1 == s.length();
    }
}
