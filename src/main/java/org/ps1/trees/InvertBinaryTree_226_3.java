package org.ps1.trees;

public class InvertBinaryTree_226_3 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        //swap left & right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //invert left
        invertTree(root.left);
        //invert right
        invertTree(root.right);
        return root;
    }
}
