package org.ps1.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94_1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        //left side
        inOrder(node.left, result);
        //root
        result.add(node.val);
        //right side
        inOrder(node.right, result);
    }
}
