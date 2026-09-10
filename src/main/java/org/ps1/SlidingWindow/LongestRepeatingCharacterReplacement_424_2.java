package org.ps1.SlidingWindow;

public class LongestRepeatingCharacterReplacement_424_2 {
    public static void main(String[] args) {

    }

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, maxLen = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                //we will remove first element
                freq[s.charAt(left) - 'A']--;
                left--;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
