package org.ps1.twopointer;

public class SubSequence_392_6 {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return s.length() == i;
    }
}
