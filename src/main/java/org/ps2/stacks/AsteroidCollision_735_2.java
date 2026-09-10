package org.ps2.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * Example 1:
 * Input: asteroids = [2,4,-4,-1]
 * Output: [2]
 */
public class AsteroidCollision_735_2 {
    public static void main(String[] args) {

    }

    /**
     *
     * we will maintain one variable to track astroid alive or not
     * Two asteroids will meet only id they are runing in opposite direction
     * we we found that scenario, we will validate below
     * stack.peek() & -asteroid
     * if stack.peek()< -asteroid
     * stack.peek--> destroy --> stack.pop()
     * if(stack.peek()== -asteroid)--> alive=false stack.pop() --> both will destroy
     * else --> -asteroid will be destroyed
     * return  the ele
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteriod : asteroids) {
            boolean isAlive = true;
            while (isAlive && !stack.isEmpty() && stack.peek() > 0 && asteriod < 0) {
                int live = stack.peek();
                if (live < -asteriod) {
                    stack.pop();
                } else if (live == -asteriod) {
                    isAlive = false;
                    stack.pop();
                } else
                    isAlive = false;
            }
            if (isAlive)
                stack.push(asteriod);
        }
        int[] op = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty())
            op[idx++] = stack.pop();
        return op;
    }
}
