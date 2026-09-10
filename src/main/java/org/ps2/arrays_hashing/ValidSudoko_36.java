package org.ps2.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoko_36 {
    public static void main(String[] args) {

    }

    /**
     * so valid sudoko means row , column, box should have unique numbers
     * so mana input can have empty boxes with '.' and numbers that needs to be validated
     * so manam oka hashset create chestam to store elements
     * as we are dealing with 2D array we need two loops
     * for r=0-->r<9
     *      for c=0 --> c<9
     * we will store the lement at particular index in number
     *  char number=board[r][c]
     *  check its a valid number if(number!='.')
     *  we will add the elements into hashset
     *  for row seen.add(number + " in row " + r)
     *          for col seen.add(number + " in col " + c)
     *              for box seen.add(number + " in box " + (r / 3) + "-" + (c / 3))
     *if anything fails to add then we can consider it as a duplicate
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char number = board[r][c];
                //check if cell is empty
                if (number != '.') {
                    //by using string encoding format we will check all three conditions
                    if (!seen.add(number + " in row " + r) ||
                            !seen.add(number + " in col " + c) ||
                            !seen.add(number + " in box " + (r / 3) + "-" + (c / 3))) {
                        return false; //repeating element is present
                    }
                }
            }

        }
        return true;
    }
}
