package org.ps1.trees;

public class BinaryTreeMaximumPathSum_124_4 {
    public static void main(String[] args) {

    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        //comparing with 0 to handle -ve values
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        //for currentpath we can use both values
        int currentPath = left + root.val + right;
        maxSum = Math.max(maxSum, currentPath);
        //return only one value to parent
        return root.val + Math.max(left, right);
    }
}
