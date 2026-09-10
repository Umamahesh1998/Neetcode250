package org.ps2.stacks;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * <p>
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * <p>
 * Input: ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * <p>
 * Output: [null, null, null, 1, 1, false]
 */
public class ImplementQueueusingStacks_232_4 {
    /**
     * here we will use two stacks one for input and other for output
     * we will add elements from input stack to output stack using moveIfRequired method
     */
    Stack<Integer> in = new Stack<>();
    Stack<Integer> op = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        moveIfRequired();
        return op.pop();
    }

    private void moveIfRequired() {
        if (op.isEmpty()) {
            while (!in.isEmpty()) {
                op.push(in.pop());
            }
        }
    }

    public int peek() {
        moveIfRequired();
        return op.peek();
    }

    public boolean empty() {
        return in.isEmpty() && op.isEmpty();
    }
}
