package org.ps2.stacks;

import java.util.Stack;

/**
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.
 * The rules of a Unix-style file system are as follows: A single period '.' represents the current directory. A double period '..' represents the previous/parent directory.
 * Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/' Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
 * Input: path = "/neetcode/practice//...///../courses"
 * Output: "/neetcode/practice/courses"
 */
public class SimplifyPath_71_5 {
    /**
     * split the input string based on '/'
     * we will use stack to store the paths
     * if we found . or "" we will continue if it is '..' we will pop the first element from stack else we will insert the element
     * then we will create a string builder to append the parts which are present in stack
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String part : path.split("/")) {

            if (part.equals(".") || part.equals("")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (String s : stack) {
            builder.append("/").append(s);
        }

        return stack.isEmpty() ? "/" : builder.toString();
    }
}
