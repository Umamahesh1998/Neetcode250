package org.ps1.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath_71_5 {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.equals("") || part.equals("."))
                continue;
            else if (part.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(part);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.insert(0, "/" + s);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}
