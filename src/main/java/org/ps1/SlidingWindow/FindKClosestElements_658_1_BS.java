package org.ps1.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements_658_1_BS {
    public static void main(String[] args) {

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
