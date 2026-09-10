package org.ps1.trees;

public class MaximumDepthOfBinaryTree_104_4 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
