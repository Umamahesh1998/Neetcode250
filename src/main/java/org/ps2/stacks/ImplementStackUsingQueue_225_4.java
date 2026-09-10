package org.ps2.stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * <p>
 * Implement the MyStack class:
 * <p>
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Input: ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * <p>
 * Output: [null, null, null, 2, 2, false]
 */
public class ImplementStackUsingQueue_225_4 {
    Queue<Integer> stack = new LinkedList<>();

    public void push(int x) {
        stack.offer(x);
        for (int i = 0; i < stack.size() - 1; i++) {
            stack.offer(stack.poll());
        }
    }

    public int pop() {
        return stack.poll();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
