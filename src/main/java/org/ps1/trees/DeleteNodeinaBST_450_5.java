package org.ps1.trees;

public class DeleteNodeinaBST_450_5 {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        //search
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            //if no left child
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            //if two childs present
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }
}
