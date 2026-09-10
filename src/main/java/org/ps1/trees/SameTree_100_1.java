package org.ps1.trees;

public class SameTree_100_1 {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //both null -> true
        if (p == null && q == null)
            return true;
        //if one null --> false
        if (p == null || q == null)
            return false;
        //val different
        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
