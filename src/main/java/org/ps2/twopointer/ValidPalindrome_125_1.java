package org.ps2.twopointer;

/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 * Example 1:
 * Input: s = "Was it a car or a cat I saw?"
 * Output: true
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
 */
public class ValidPalindrome_125_1 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
