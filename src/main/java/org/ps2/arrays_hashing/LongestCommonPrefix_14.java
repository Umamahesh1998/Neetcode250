package org.ps2.arrays_hashing;

/**
 * You are given an array of strings strs. Return the longest common prefix of all the strings.
 * If there is no longest common prefix, return an empty string "".
 * Example 1:
 * Input: strs = ["bat","bag","bank","band"]
 * Output: "ba"
 */
public class LongestCommonPrefix_14 {
    public static void main(String[] args) {

    }

    /**
     * we will create string builder to append the predfix
     * we will run two loops one from 0 --> strs[0].lenght and  0-->strs.lenght
     * we will check if the lenght of strs[0] is greater then other elements or element at index i of strs[0] is not matching with other elements chars
     * if(i>=strs[j].lenght || strs[0].charAt(i)!=strs[j].charAt(i))  --> return s1.toString();
     * s1.append(strs[0].charAt(i)
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
