package org.ps2.twopointer;

/**
 * You are given a string s, return true if the s can be a palindrome after deleting at most one character from it.
 * A palindrome is a string that reads the same forward and backward.
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 * Example 1:
 * Input: s = "aca"
 * Output: true
 */
public class ValidPalindromeII_680_1 {
    public static void main(String[] args) {

    }

    /**
     * we need to check two things here
     * 1. given string is palindrome or not
     * if not we need to check it y removing one element from it
     *
     */
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                //removing one element to check we can acheive palindrome
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }

        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
