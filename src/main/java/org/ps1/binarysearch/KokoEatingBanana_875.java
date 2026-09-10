package org.ps1.binarysearch;

public class KokoEatingBanana_875 {
    public static void main(String[] args) {

    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles)
            high = Math.max(pile, high);
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }
}
