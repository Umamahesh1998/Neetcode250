package org.ps1.trees;

public class ValidateBinarySearchTree_98_5 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (root.val <= minValue || root.val >= maxValue)
            return false;
        return validate(root.left, minValue, root.val)
                && validate(root.right, root.val, maxValue);
    }
}
