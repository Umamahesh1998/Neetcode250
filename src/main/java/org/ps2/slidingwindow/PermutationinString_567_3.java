package org.ps2.slidingwindow;

import java.util.Arrays;

/**
 * You are given two strings s1 and s2.
 * Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
 * Both strings only contain lowercase letters.
 * Example 1:
 * Input: s1 = "abc", s2 = "lecabee"
 * Output: true
 */
public class PermutationinString_567_3 {

    /**
     * s1 oka any of the permutation s2 lo vuntey then we will return true else false
     * manam two arrays maintain chestam each of lenght 26 need, window
     * initial ga we will run a loop from i=0-->s1.len
     *      we will populate the need, window with the character freq
     *       for (int i = 0; i < s1.length(); i++) {
     *             need[s1.charAt(i) - 'a']++;
     *             window[s2.charAt(i) - 'a']++;
     *         }
     * we will check if need==window --> true
     * if not we will run loop from i=s1.length()-->s2.length()
     * we wont touch need now we will use it as SOT
     * in window array we will appened s.charAt(right)-'a' value and decrease s.charAt(right-s1.length())-'a'
     * for (int right = s1.length(); right < s2.length(); right++) {
     *             window[s2.charAt(right) - 'a']++;
     *             window[s2.charAt(right - s1.length()) - 'a']--;
     *             if (Arrays.equals(need, window))
     *                 return true;
     *         }
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] need = new int[26], window = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, window))
            return true;
        for (int right = s1.length(); right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;
            window[s2.charAt(right - s1.length()) - 'a']--;
            if (Arrays.equals(need, window))
                return true;
        }
        return false;
    }
}
