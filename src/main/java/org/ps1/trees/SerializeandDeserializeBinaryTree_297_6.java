package org.ps1.trees;

public class SerializeandDeserializeBinaryTree_297_6 {
    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    private int index = 0;

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        index = 0;
        return build(values);
    }

    private TreeNode build(String[] values) {
        if (values[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index++]));
        root.left = build(values);
        root.right = build(values);
        return root;
    }
}
