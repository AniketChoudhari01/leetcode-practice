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
    List<Integer> inorder;
    private void inorderTraversal(TreeNode root){
        if(root == null) return;
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        // TreeNode currNode = root;
        //morris inorder traversal
        inorder = new ArrayList<>();
        inorderTraversal(root);
        // while (currNode != null) {
        //     if (currNode.left == null) {
        //         inorder.add(currNode.val);
        //         currNode = currNode.right;
        //     } else {
        //         TreeNode temp = currNode.left;
        //         while (temp.right != null && temp.right != currNode) {
        //             temp = temp.right;
        //         }
        //         if (temp.right == null) {
        //             temp.right = currNode;
        //             currNode = currNode.left;
        //         }
        //         if (temp.right == currNode) {
        //             temp.right = null;
        //             inorder.add(currNode.val);
        //             currNode = currNode.right;
        //         }
        //     }
        // }
        int prev = inorder.get(0);
        for(int i = 1; i<inorder.size(); i++){
            int curr = inorder.get(i);
            if(curr <= prev) return false;
            prev = curr;
        }
        // System.out.println(inorder);
        return true;
    }
}