package org.ps1.binarysearch;

public class CapacityToShipPackagesWithinDdays_1011 {
    public static void main(String[] args) {
        int weights[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, days = 5;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int requiredDays = 1;
            int currentWeight = 0;
            for (int wg : weights) {
                if (currentWeight + wg > mid) {
                    requiredDays++;
                    currentWeight = wg;
                } else {
                    currentWeight += wg;
                }
            }
            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}
