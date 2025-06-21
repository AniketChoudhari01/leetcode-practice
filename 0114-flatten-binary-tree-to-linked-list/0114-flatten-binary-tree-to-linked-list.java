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
    public void flatten(TreeNode root) {
        //by using morris preorder traversal threaded BT
        TreeNode currNode = root;
        while(currNode != null){
            if(currNode.left == null){
                currNode = currNode.right;
            }else{
                TreeNode leftNode = currNode.left;
                TreeNode tempNode = leftNode;
                while(tempNode.right != null){
                    tempNode = tempNode.right;
                }
                tempNode.right = currNode.right;
                currNode.left = null;
                currNode.right = leftNode;
                currNode = leftNode;
            }
        }

    }
}