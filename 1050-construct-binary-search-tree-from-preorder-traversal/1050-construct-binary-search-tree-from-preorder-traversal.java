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
    // private void buildBST(int preorder[], int currNode, TreeNode root){
    //     if(root == null) return;
    //     if(root.val > currNode){
    //         buildBST(preorder, currNode, root.left);
    //         root.left = new TreeNode(currNode);
    //         return;
    //     }
    //     if(root.val < currNode){
    //         buildBST(preorder, currNode, root.right);
    //         root.right = new TreeNode(currNode);
    //         return;
    //     }
    //     return;
    // }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1; i<preorder.length; i++){
            int currNode = preorder[i];
            TreeNode curr = root;
            while(curr != null){
                if(curr.val < currNode){
                    if(curr.right == null){
                        curr.right = new TreeNode(currNode);
                        break;
                    }else{
                        curr = curr.right;
                    }
                }
                if(curr.val > currNode){
                    if(curr.left == null){
                        curr.left = new TreeNode(currNode);
                        break;
                    }else{
                        curr = curr.left;
                    }
                }
            }
            // buildBST(preorder, preorder[i], root);
        }
        return root;
    }
}