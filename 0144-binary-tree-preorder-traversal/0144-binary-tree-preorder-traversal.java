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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode currNode = root;
        while(currNode != null){
            if(currNode.left == null){
                preorder.add(currNode.val);
                currNode = currNode.right;
            }else{
                preorder.add(currNode.val);
                TreeNode tempNode = currNode.left;
                while(tempNode.right != null){
                    tempNode = tempNode.right;
                }
                // if(tempNode.right == null){
                    tempNode.right = currNode.right;
                    currNode = currNode.left;
                // }

            }
        }
        return preorder;
    }
}