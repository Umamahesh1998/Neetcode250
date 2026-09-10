package org.ps1.binarysearch;

public class MedianofTwoSortedArrays_4 {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Binary search always on smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;

        int low = 0, high = m;
        int left = (m + n + 1) / 2;
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = left - i;
            int Aleft = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int Bleft = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Correct partition
            if (Aleft <= Bright && Bleft <= Aright) {
                if ((m + n) % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }
                return ((Math.max(Aleft, Bleft)) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright)
                high = i - 1;
            else
                low = i + 1;
        }
        return 0.0;
    }
}
