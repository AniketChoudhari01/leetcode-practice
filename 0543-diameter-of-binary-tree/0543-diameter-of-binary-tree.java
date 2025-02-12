class Solution {
    int diameter;
    private int findDepth(TreeNode root){
        if(root == null) return 0;

        int leftHeight = findDepth(root.left);
        int rightHeight = findDepth(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        diameter = 0;
        int height = findDepth(root);
        return diameter;
    }
}