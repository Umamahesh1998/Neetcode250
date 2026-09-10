package org.ps1.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144_1 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode node, List<Integer> result) {
        if(node==null)
            return;
        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }
}
