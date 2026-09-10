package org.ps1.arraysAndHashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestCommonPrefix_14 {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return s1.toString();
            }
            s1.append(strs[0].charAt(i));
        }
        return s1.toString();
    }
}
