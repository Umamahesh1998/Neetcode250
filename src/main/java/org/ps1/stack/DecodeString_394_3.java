package org.ps1.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString_394_3 {
    public static void main(String[] args) {

    }

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
                num = 0;
                current = new StringBuilder();
            } else if (ch == ']') {
                int count = counterStack.pop();
                String str = stringStack.pop();
                StringBuilder temp = new StringBuilder(str);
                for (int i = 0; i < count; i++) {
                    temp.append(current);
                }
                current = temp;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
