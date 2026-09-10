package org.ps1.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105_6 {
    private int preIndex = 0;
    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            inOrderMap.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right)
            return null;

        //preorder first element is root
        int rootvalue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootvalue);

        //find that root element in inorder
        int rootIndex = inOrderMap.get(rootvalue);

        //build left
        root.left = build(preorder, left, rootIndex - 1);

        //build right
        root.right = build(preorder, rootIndex + 1, right);
        return root;
    }
}
