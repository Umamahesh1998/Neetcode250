package org.ps2.arrays_hashing;

import java.util.*;

/**
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 * Example 1:
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 */
public class Group_Anagram_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String st : strs) {
            // 1. Only use 26 slots for lowercase English letters
            char[] count = new char[26];
            for (char c : st.toCharArray()) {
                count[c - 'a']++;
            }

            // 2. Fast string creation from char array
            String key = String.valueOf(count);

            // 3. Clean, modern Java Map merging
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(st);
        }

        return new ArrayList<>(map.values());
    }
}
/**
 * for (String st : strs) {
 * char[] chars = st.toCharArray();
 * Arrays.sort(chars);
 * String key=new String(chars);
 * map.getOrDefault(key,new ArrayList<>()).add(st);
 * map.compute(, (k, v) ->{
 * if(v==null) {
 * v = new ArrayList<>();
 * }
 * v.add(st);
 * return v;
 * } );
 * }
 * return new ArrayList<>(map.values());
 */
