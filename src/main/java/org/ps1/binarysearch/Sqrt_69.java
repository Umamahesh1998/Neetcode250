package org.ps1.binarysearch;

public class Sqrt_69 {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        if (x < 2)
            return 0;
        int low = 0, high = x / 2, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
