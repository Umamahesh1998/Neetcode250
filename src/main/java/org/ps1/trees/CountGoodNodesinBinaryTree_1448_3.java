package org.ps1.trees;

public class CountGoodNodesinBinaryTree_1448_3 {
    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val >= maxSoFar)
            count = 1;

        maxSoFar = Math.max(node.val, maxSoFar);
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);
        return count;
    }
}
