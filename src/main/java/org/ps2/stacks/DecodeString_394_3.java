package org.ps2.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString_394_3 {
    /**
     * Every time [ vachinappudu:
     * "Current situation ni save chey"
     * Every time ] vachinappudu:
     * "Saved situation ni retrieve chesi,
     * current decoded string ni required count times repeat chey"
     */
    /**
     * we use 2 stacks and 1 integer variable here
     * we will keep track of num using num field
     * when ever we reached [ we will store the values in 2 stacks
     * when ever we reach ] we will start appending the string by num times
     */
    public String decodeString(String s) {
        Deque<Integer> counterStack = new ArrayDeque<>();
        Deque<String> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                //save current context
                counterStack.push(num);
                stringStack.push(current.toString());
                //refresh values
                num = 0;
                current = new StringBuilder();
            } else if (ch == ']') {
                //start processing
                int count = counterStack.pop();
                String str = stringStack.pop();
                StringBuilder temp = new StringBuilder(str);
                //append current string to temp for count times
                for (int i = 0; i < count; i++) {
                    temp.append(current);
                }
                //update the current value
                current = temp;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
