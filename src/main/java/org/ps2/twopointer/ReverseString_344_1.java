package org.ps2.twopointer;

/**
 * You are given an array of characters which represents a string s. Write a function which reverses a string.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Input: s = ["n","e","e","t"]
 * Output: ["t","e","e","n"]
 */
public class ReverseString_344_1 {
    public static void main(String[] args) {

    }

    /**
     * we follow twopointer varient 1 approach
     * two pointers opposite direction lo tesukuntam
     * we will move them towards each other left++, right--
     * ah index lo vunna element ni swap chestam
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }
}
