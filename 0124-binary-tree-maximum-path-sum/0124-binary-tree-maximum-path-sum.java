class Solution {
    int maxSum;
    private int getMaxSum(TreeNode root){
        if(root == null) return 0;

        int leftSum = getMaxSum(root.left);
        int rightSum = getMaxSum(root.right);

        int pathSum = root.val + leftSum + rightSum;

        int currSum = Math.max(root.val, root.val + Math.max(leftSum , rightSum));
        maxSum = Math.max(Math.max(maxSum, pathSum), Math.max(currSum , root.val));

        return currSum;
    }
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        int hgt = getMaxSum(root);
        return maxSum; 
    }
}