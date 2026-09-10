package org.ps2.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 * The input string s is valid if and only if:
 * Every open bracket is closed by the same type of close bracket.
 * Open brackets are closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 * Example 1:
 * Input: s = "([{}])"
 * Output: true
 */
public class ValidParentheses_20_1 {
    /**
     * Basic ga we need to check valid parentheses or not so
     * we will use stack here to keep an track of one side elements and we will check whether they are following same gap between open and close
     * create stack
     * push elements that are equals to ( { [
     * when ever you hit closing element just pop the top element from stack and check the opening and closing are matching or not
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char ch = stack.pop();
                if (ch != '(' && c == ')' || ch != '{' && c == '}' || ch!= '[' && c == ']')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
