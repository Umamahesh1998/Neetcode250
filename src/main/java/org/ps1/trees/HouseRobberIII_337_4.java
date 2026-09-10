package org.ps1.trees;

public class HouseRobberIII_337_4 {
    public static void main(String[] args) {
        //root = [3,2,3,null,3,null,1]
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode lr1 = new TreeNode(3);
        TreeNode rr1 = new TreeNode(1);
        left.right = lr1;
        right.right = rr1;
        root.left = left;
        root.right = right;
        rob(root);
    }

    public static int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    // result[0] = maximum money if we ROB this node
    // result[1] = maximum money if we DON'T ROB this node
    private static int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        //rob current-->cannot rob child
        int rob = root.val + left[1] + right[1];
        //dont rob current-->child can be robbed or not
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}
