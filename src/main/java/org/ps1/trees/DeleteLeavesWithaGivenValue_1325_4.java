package org.ps1.trees;

public class DeleteLeavesWithaGivenValue_1325_4 {
    public static void main(String[] args) {

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;

        //first check childs
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        //check parent
        if (root.left == null && root.right == null && root.val == target)
            return null;

        return root;
    }
}
