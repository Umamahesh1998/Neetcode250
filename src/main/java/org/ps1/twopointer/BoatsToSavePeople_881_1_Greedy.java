package org.ps1.twopointer;

import java.util.Arrays;

public class BoatsToSavePeople_881_1_Greedy {
    public static void main(String[] args) {

    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, boats = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit)
                left++;
            right--;
            boats++;
        }
        return boats;
    }
}
