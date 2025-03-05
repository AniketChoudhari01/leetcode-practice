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
    private boolean traverseTogether(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode==null) return true;
        if((leftNode !=null && rightNode==null) || (leftNode == null && rightNode != null) ){
            return false;
        }
        if( leftNode.val != rightNode.val){
            return false;
        }
        boolean left = traverseTogether(leftNode.right, rightNode.left);
        boolean right = traverseTogether(leftNode.left, rightNode.right);
        return left & right;
    }
    public boolean isSymmetric(TreeNode root) {
        return traverseTogether(root, root);
    }
}