package org.ps1.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    static class Pair {
        String value;
        int timeStamp;

        public Pair(int timeStamp, String value) {
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        List<Pair> pairs = map.get(key);
        int low = 0, high = pairs.size() - 1;
        String ans = "";
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pairs.get(mid).timeStamp <= timestamp) {
                ans = pairs.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

public class TimeBasedKeyValueStore_981 {
    public static void main(String[] args) {

    }

}
