package org.ps2.twopointer;

import java.util.Arrays;

/**
 * You are given an integer array people where people[i] is the weight of the ith person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 * Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person.
 * Example 1:
 * Input: people = [5,1,4,2], limit = 6
 * Output: 2
 */
public class BoatsToSavePeople_881_1_Greedy {
    public static void main(String[] args) {

    }

    /***
     * we use two pointer approach here we need to calculate the num of boats required to save people
     * we will create two pointers left=0, right=people.length-1
     * we will check if(people[left]+people[right]<limit)--> left++
     * right--
     * increase boat count
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, boat = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boat++;
        }
        return boat;
    }
}
