package org.ps1.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145_1 {
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    //left --> right --> root
    private void postOrder(TreeNode node, List<Integer> result) {
        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.val);
    }
}
