package org.ps2.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 * Return the integer that represents the evaluation of the expression.
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 * Example 1:
 * Input: tokens = ["1","2","+","3","*","4","-"]
 * Output: 5
 * Explanation: ((1 + 2) * 3) - 4 = 5
 */
public class EvaluateReversePolishNotation_150_3 {
    public static void main(String[] args) {

    }

    /**
     * Basic ga enti antey we have one array which contains both numerical digits and operations
     * if it is numeric digit we will push into stack
     * if it is any operation we will pop the digits from the stack and perform the operation and push the updated value into stack
     *
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int second = stack.pop(), first = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                }
            }
        }
       return stack.pop();
    }
}
