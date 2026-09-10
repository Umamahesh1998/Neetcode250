package org.ps1.trees;


import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInBST_230_5_1 {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            //go complete left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //visit node
            curr = stack.pop();
            k--;
            if (k == 0)
                return curr.val;
            //move right
            curr = curr.right;
        }
        return -1;
    }
}
