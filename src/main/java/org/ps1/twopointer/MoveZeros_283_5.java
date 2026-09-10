package org.ps1.twopointer;

public class MoveZeros_283_5 {
    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
