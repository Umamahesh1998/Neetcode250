package org.ps2.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * <p>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Each function should run in O(1) time.
 * Example 1:
 * Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
 * Output: [null,null,null,null,0,null,2,1]
 */
public class MinStack_155_4 {

    /**
     * basic ga to build minStack we will use two stacks one for regular insertion other for min tracking
     */
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack_155_4() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty())
            minStack.push(val);
        else minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
