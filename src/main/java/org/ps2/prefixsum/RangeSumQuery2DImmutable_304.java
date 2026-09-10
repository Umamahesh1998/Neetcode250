package org.ps2.prefixsum;

/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Implement the NumMatrix class:
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * You must design an algorithm where sumRegion works on O(1) time complexity.
 */
public class RangeSumQuery2DImmutable_304 {
    public static void main(String[] args) {

    }

    /**
     * Here is a concise, interview-ready cheat sheet for your notes:
     * ## 📌 2D Prefix Sum Intuition## 1. The Goal
     * <p>
     * * Calculate the sum of any sub-matrix rectangle in O(1) time.
     * * Avoid looping through the matrix every time sumRegion() is called to prevent Time Limit Exceeded (TLE).
     * <p>
     * ## 2. Matrix Padding (Size: (R+1) × (C+1))
     * <p>
     * * Action: Create a prefix matrix with an extra row and column initialized to 0.
     * * Intuition: Acts as a safety wall. It prevents "Index Out of Bounds" errors when checking elements in the top row or leftmost column.
     * <p>
     * ## 3. Building the Table (Pre-computation)
     * <p>
     * * Formula: Prefix[r+1][c+1] = Matrix[r][c] + Top + Left - TopLeft
     * * Intuition:
     * * Add the current cell to the accumulated sum of the Top block and Left block.
     * * Subtract the Top-Left block once because it overlaps and gets added twice.
     * <p>
     * ## 4. Querying the Region (Answering in O(1))
     * <p>
     * * Formula: RegionSum = FullBox - TopBox - LeftBox + OverlapBox
     * * Intuition:
     * * Take the sum of the entire big rectangle from (0,0) to the bottom-right corner.
     * * Subtract the unwanted areas above (TopBox) and to the left (LeftBox).
     * * Add back the OverlapBox at the top-left corner because it was subtracted twice.
     */
    int[][] prefix;

    public void NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int rows = matrix.length;
        int col = matrix[0].length;
        prefix = new int[rows][col];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < col; c++) {
                prefix[r + 1][c + 1] = matrix[r][c] +
                        prefix[r][c + 1] + prefix[r + 1][c] - prefix[r][c];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
                - prefix[row1][col2 + 1]
                - prefix[row2 + 1][col1]
                + prefix[row1][col1];
    }
}
