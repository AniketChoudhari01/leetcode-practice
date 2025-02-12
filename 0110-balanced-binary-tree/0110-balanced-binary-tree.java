class Solution {
    private int findHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = findHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = findHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        int height = findHeight(root);
        return height != -1;
    }
}