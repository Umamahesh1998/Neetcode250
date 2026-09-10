package org.ps1.trees;

public class DiameterofBinaryTree_543_4 {
    public static void main(String[] args) {

    }

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        //diameter passing through currentNode
        diameter = Math.max(diameter, leftHeight + rightHeight);
        //return height to parent
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
