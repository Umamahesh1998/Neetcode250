package org.ps1.stack;

import java.util.Stack;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        moveIfRequired();
        return out.pop();
    }

    private void moveIfRequired() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public int peek() {
        moveIfRequired();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

public class ImplementQueueusingStacks_232_4 {
    public static void main(String[] args) {

    }
}
