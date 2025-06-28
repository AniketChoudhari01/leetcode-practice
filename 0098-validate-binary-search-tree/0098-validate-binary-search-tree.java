/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean checkBST(TreeNode root, Long min, Long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        boolean leftCheck = checkBST(root.left, min, (long)root.val);
        boolean rightCheck = checkBST(root.right, (long)root.val, max);
        return leftCheck && rightCheck;
    }
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}