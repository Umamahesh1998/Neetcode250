package org.ps1.arraysAndHashing;

import java.util.*;

public class GroupAnagram_49 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);
            map.compute(new String(key), (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(s);
                return v;
            });
        }
        return new ArrayList<>(map.values());
    }
}
