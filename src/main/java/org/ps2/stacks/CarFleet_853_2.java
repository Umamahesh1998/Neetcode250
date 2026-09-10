package org.ps2.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * There are n cars traveling to the same destination on a one-lane highway.
 * You are given two arrays of integers position and speed, both of length n.
 * position[i] is the position of the ith car (in miles)
 * speed[i] is the speed of the ith car (in miles per hour)
 * The destination is at position target miles.
 * A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
 * A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
 * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
 * Return the number of different car fleets that will arrive at the destination.
 * Example 1:
 * Input: target = 10, position = [1,4], speed = [3,2]
 * Output: 1
 */
public class CarFleet_853_2 {
    /**
     *
     */
    /**
     * Basic ga oka one way road lo cars travel avutunai we need to identify the fleet count
     * time > previous fleet time → separate fleet
     * time <= previous fleet time → same fleet
     * we will store the position and speed in two dimension array
     * we will sort that array based on the position
     * we will run a loop i=0-->n
     * we will calculate the time
     * if the time is > then previous time present in stack we will consider it as a new fleet
     * return the stack size
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            if (stack.isEmpty() || stack.peek() < time)
                stack.push(time);
        }
        return stack.size();
    }
}
