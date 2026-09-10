package org.ps1.twopointer;

public class ReverseString_344_1 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }

    }
}
