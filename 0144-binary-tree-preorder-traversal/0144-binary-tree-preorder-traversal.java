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
    private void preOrderTraversal(TreeNode root, List<Integer> preOrder){
        if(root == null) return;
        preOrder.add(root.val);
        preOrderTraversal(root.left, preOrder);
        preOrderTraversal(root.right, preOrder);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        preOrderTraversal(root, preOrder);
        return preOrder;
    }
}