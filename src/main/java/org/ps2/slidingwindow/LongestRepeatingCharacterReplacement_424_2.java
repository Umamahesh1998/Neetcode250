package org.ps2.slidingwindow;

/**
 * You are given a string s consisting of only uppercase english characters and an integer k.
 * You can choose up to k characters of the string and replace them with any other uppercase English character.
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 * Example 1:
 * Input: s = "XYYX", k = 2
 * Output: 4
 */
public class LongestRepeatingCharacterReplacement_424_2 {
    public static void main(String[] args) {

    }

    /**
     * basic ga we have two inputs string s, int k ask enti antey--> we can replace upto k characters from the s with any other characters
     * then we should send the maxlength of substring that contains only one distinct character
     * we will initiate 4 variables int maxLen, maxFreq, left int[26] freq
     * we will run a loop from i=0-->s.length
     * we will calculate the element freq and store it in freq array
     * for every element we will check maxFreq
     * we will check if (right-left+1)-maxFreq>k --> we will remove element from left
     * we will main maxlen value
     */
    public int characterReplacement(String s, int k) {
        int maxLen = 0, maxFreq = 0, left = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
