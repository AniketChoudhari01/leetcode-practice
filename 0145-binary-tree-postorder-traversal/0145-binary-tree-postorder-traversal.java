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
    private void postOrderTraversal(TreeNode root, List<Integer> li){
        if(root == null) return ;
        postOrderTraversal(root.left, li);
        postOrderTraversal(root.right, li);
        li.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        postOrderTraversal(root, postOrder);
        return postOrder;
    }
}