package org.ps2.arrays_hashing;

/**
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 * Two strings are anagrams if they contain the same characters, with each character appearing the same number of times, regardless of order.
 * Example 1:
 * Input: s = "racecar", t = "carrace"
 * Output: true
 */
public class ValidAnagram_242 {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        int[] chs = new int[126];
        for (char sc : s.toCharArray()) {
            chs[sc - 'a']++;
        }
        for (char tc : t.toCharArray()) {
            chs[tc - 'a']--;
        }
        for (int ch : chs) {
            if (ch != 0)
                return false;
        }
        return true;
    }
}
