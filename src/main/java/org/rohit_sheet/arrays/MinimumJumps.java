package org.rohit_sheet.arrays;

/**
 * Given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.
 * For example:
 * If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
 * If arr[i] = 0, you cannot jump forward from that position.
 * Find the minimum number of jumps needed to move from the first position in the array to the last position.
 * Note:  Return -1 if you can't reach the end of the array.
 * Examples :
 * Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
 * Output: 3
 * Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last.
 */
public class MinimumJumps {
    public static void main(String[] args) {

    }

    public int minJumps(int[] arr) {
        // code here
        int n = arr.length;

        if (n <= 1)
            return 0;

        if (arr[0] == 0)
            return -1;

        int jumps = 0; //hold count of jumps
        int farthest = 0; //max distance we can jump;
        int currentend = 0; //current boundary
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, arr[i] + i);
            if (currentend == i) {
                jumps++;
                currentend = farthest;
                if (currentend >= n - 1)
                    return jumps;
                if (currentend == i)
                    return -1;
            }
        }
        return -1;
    }
}
