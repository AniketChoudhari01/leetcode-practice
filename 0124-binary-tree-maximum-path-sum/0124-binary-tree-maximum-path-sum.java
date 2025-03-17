class Solution {
    int maxi;
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int pathSum = root.val + leftSum + rightSum;
        int currSum = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
        maxi = Math.max(Math.max(maxi, currSum), Math.max(pathSum, root.val));
        return currSum;
    }
    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
        int total = dfs(root);
        return maxi;
    }
}