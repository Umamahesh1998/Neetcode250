package org.rohit_sheet.arrays;

/**
 * Given an array containing both positive and negative numbers in random order. The task is to rearrange the array elements so that all negative numbers appear before all positive numbers.
 * Note:
 * Given array does not contain any zeroes.
 * Order of resultant array does not matter.
 * Example :
 * Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
 * Output: -12 -13 -5 -7 -3 -6 11 6 5
 */
public class MoveAllNegAndPositiveToOppEnd {
    public static void main(String[] args) {

    }

    public void segregateElements(int[] arr) {
        // code here
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] > 0)
                left++;
            while (left < right && arr[right] < 0)
                right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

    }

    public void segregateElementsPreserverOrder(int[] arr) {
        int[] ans = new int[arr.length];
        int index = 0;
        for (int num : arr)
            if (num > 0)
                ans[index++] = num;
        for (int num : arr)
            if (num < 0)
                ans[index++] = num;
        arr = ans;
    }

    public void segregateElementsInplace(int[] arr) {

        int positiveIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {

                int temp = arr[i];

                // Shift elements right
                for (int j = i; j > positiveIndex; j--) {
                    arr[j] = arr[j - 1];
                }

                arr[positiveIndex] = temp;
                positiveIndex++;
            }
        }
    }

}
