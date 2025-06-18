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
    Map<Integer, Integer> ioMap;
    private TreeNode constructBT(int []preorder, int []inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = ioMap.get(preorder[preStart]);
        int numsLeft = idx - inStart;
        root.left = constructBT(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, idx - 1);
        root.right = constructBT(preorder, inorder, preStart + numsLeft + 1, preEnd, idx + 1, inEnd);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ioMap = new HashMap<>();
        int n = inorder.length;
        for(int i=0; i<inorder.length; i++){
            ioMap.put(inorder[i], i);
        }
        return constructBT(preorder, inorder, 0, n-1, 0, n-1);
    }
}