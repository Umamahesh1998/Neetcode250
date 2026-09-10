package org.ps1.arraysAndHashing;

import java.util.Arrays;

/**
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * <p>
 * Output: true
 */
public class ValidAnagram_242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        isAnagram(s, t);
    }

    public static boolean isAnagram(String s, String t) {
        int[] ans = new int[126];
        for (char c : s.toCharArray())
            ans[c]++;
        for (char c : t.toCharArray())
            ans[c]--;
        for (int i : ans)
            if (i != 0)
                return false;

        return true;
    }

}
