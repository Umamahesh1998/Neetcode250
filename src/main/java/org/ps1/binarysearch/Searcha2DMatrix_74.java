package org.ps1.binarysearch;

public class Searcha2DMatrix_74 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n, col = mid % n;
            int value = matrix[row][col];
            if (value == target)
                return true;
            else if (value < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
