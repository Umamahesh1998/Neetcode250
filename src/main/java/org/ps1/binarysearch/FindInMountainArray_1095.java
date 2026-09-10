package org.ps1.binarysearch;

interface MountainArray {
    public int get(int index);

    public int length();
}

public class FindInMountainArray_1095 {
    public static void main(String[] args) {

    }


    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        // 1. Find peak
        int low = 0;
        int high = n - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int peak = low;

        // 2. Search increasing part
        int left = binarySearchAscending(
                mountainArr, target, 0, peak
        );

        if (left != -1)
            return left;

        // 3. Search decreasing part
        return binarySearchDescending(
                mountainArr, target, peak + 1, n - 1
        );
    }


    private int binarySearchAscending(
            MountainArray arr,
            int target,
            int low,
            int high) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int value = arr.get(mid);

            if (value == target)
                return mid;

            if (value < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }


    private int binarySearchDescending(
            MountainArray arr,
            int target,
            int low,
            int high) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int value = arr.get(mid);

            if (value == target)
                return mid;

            if (value < target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

}
