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
    private void inOrderTraversal(TreeNode root, List<Integer> li){
        if(root == null) return;
        inOrderTraversal(root.left, li);
        li.add(root.val);
        inOrderTraversal(root.right, li);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        return inOrder;
    }
}