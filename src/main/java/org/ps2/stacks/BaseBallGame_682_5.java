package org.ps2.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
 * Given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
 * An integer x: Record a new score of x.
 * '+': Record a new score that is the sum of the previous two scores.
 * 'D': Record a new score that is the double of the previous score.
 * 'C': Invalidate the previous score, removing it from the record.
 * Return the sum of all the scores on the record after applying all the operations.
 * Example 1:
 * Input: ops = ["1","2","+","C","5","D"]
 * Output: 18
 */
public class BaseBallGame_682_5 {
    public static void main(String[] args) {

    }

    /**
     * basic ga we use varient 5 in stack --> real world process ni simulate cheyadaniki use chestam
     * here manaki 3 conditions vunnai
     * so based on the non numeric value we will perform one action and push that new value to stack
     * at the end stack nunchi all numerical values tesukuni we will return total
     */
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int total = 0;
        for (String s : operations) {
            if ("C".equals(s))
                stack.pop();
            else if ("+".equals(s)) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            } else if ("D".equals(s))
                stack.push(stack.peek() * 2);
            else
                stack.push(Integer.parseInt(s));
        }
        while (!stack.isEmpty())
            total += stack.pop();

        return total;
    }

}
