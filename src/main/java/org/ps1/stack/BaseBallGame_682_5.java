package org.ps1.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseBallGame_682_5 {
    public static void main(String[] args) {
        //ops = ["5","2","C","D","+"]
    }

    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int total = 0;
        for (String s : operations) {
            if (s.equals("C"))
                stack.pop();
            else if (s.equals("D"))
                stack.push(stack.peek() * 2);
            else if (s.equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            } else
                stack.push(Integer.parseInt(s));
        }
        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}
