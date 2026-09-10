package org.ps1.SlidingWindow;

import java.util.Arrays;

public class PermutationinString_567_3 {
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        //we need two arrays
        int[] need = new int[26];
        int[] window = new int[26];

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
