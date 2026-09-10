package org.ps1.twopointer;

/**
 * its a varient 4 model
 * Rendu vere arrays/lists ni okkokka pointer tho traverse chesi merge cheyadam.
 */
public class MergeStringsAlternately_1768_4 {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        int l1 = 0, r1 = word1.length(), l2 = 0, r2 = word2.length(), k = 0;
        char[] ch = new char[word1.length() + word2.length()];
        while (l1 < r1 && l2<r2) {
            ch[k++] = word1.charAt(l1++);
            ch[k++] = word2.charAt(l2++);
        }
        while (l1 < r1) {
            ch[k++] = word1.charAt(l1++);
        }
        while (l2 < r2) {
            ch[k++] = word1.charAt(l2++);
            l2++;
        }
        return new String(ch);
    }
}
