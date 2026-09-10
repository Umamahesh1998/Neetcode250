package org.ps1.linkedList;

public class FindtheDuplicateNumber_287_5 {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        //detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //find enterance
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
