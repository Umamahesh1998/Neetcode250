package org.ps1.twopointer;

public class TwoSumII_InputArrayIsSorted_167_1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length==0){
            return new int[]{};
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left, right};
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
