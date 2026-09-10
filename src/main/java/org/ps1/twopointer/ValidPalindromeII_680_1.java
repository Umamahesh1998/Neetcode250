package org.ps1.twopointer;

public class ValidPalindromeII_680_1 {
    public static void main(String[] args) {

    }

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int r) {
        while (i < r) {
            if (s.charAt(i) != s.charAt(r)) {
                return false;
            }
            i++;
            r--;
        }
        return true;

    }
}
