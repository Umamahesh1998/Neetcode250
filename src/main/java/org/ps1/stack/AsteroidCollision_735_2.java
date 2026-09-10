package org.ps1.stack;

import java.util.Stack;

public class AsteroidCollision_735_2 {
    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean isAlive = true;
            while (isAlive && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                if (top < -asteroid) {
                    stack.pop();
                } else if (top == -asteroid) {
                    isAlive = false;
                    stack.pop();
                } else {
                    isAlive = false;
                }
            }
            if (isAlive)
                stack.push(asteroid);
        }
        int[] arr = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}
