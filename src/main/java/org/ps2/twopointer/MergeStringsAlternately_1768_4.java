package org.ps2.twopointer;

/**
 * You are given two strings, word1 and word2. Construct a new string by merging them in alternating order, starting with word1 — take one character from word1, then one from word2, and repeat this process.
 * If one string is longer than the other, append the remaining characters from the longer string to the end of the merged result.
 * Return the final merged string.
 * Example 1:
 * Input: word1 = "abc", word2 = "xyz"
 * Output: "axbycz"
 */
public class MergeStringsAlternately_1768_4 {
    /**
     * we use two pointer each work on separate strings we will create one array to store the merged string
     */
    public String mergeAlternately(String word1, String word2) {
        int left1 = 0, left2 = 0, right1 = word1.length(), right2 = word2.length();
        char[] ch = new char[word1.length() + word2.length()];
        int k = 0;
        while (left1 < right1 && left2 < right2) {
            ch[k++] = word1.charAt(left1++);
            ch[k++] = word2.charAt(left2++);
        }
        while (left1 < right1) {
            ch[k++] = word1.charAt(left1++);
        }
        while (left2 < right2) {
            ch[k++] = word2.charAt(left2++);
        }
        return String.valueOf(ch);
    }
}
