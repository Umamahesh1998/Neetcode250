package org.ps1.binarysearch;

public class GuessNumberHigherorLower_374 {
    public static void main(String[] args) {

    }

    int guess(int n) {
        return 0;
    }

    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);
            if (result == 0)
                return mid;
            if (result == -1)
                high = mid - 1;
            if (result == 1)
                low = mid + 1;
        }
        return -1;
    }
}
