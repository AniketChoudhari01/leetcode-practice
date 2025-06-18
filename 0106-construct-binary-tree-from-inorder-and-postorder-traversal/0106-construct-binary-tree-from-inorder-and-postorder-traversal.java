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
    private TreeNode constBT(int []inorder, int []postorder, int postStart, int postEnd, int inStart, int inEnd){
        if(postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = ioMap.get(postorder[postEnd]);
        int numsLeft = idx - inStart;
        root.left = constBT(inorder, postorder, postStart, postStart +  numsLeft - 1, inStart, idx - 1);
        root.right = constBT(inorder, postorder, postStart + numsLeft, postEnd - 1, idx + 1, inEnd);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        ioMap = new HashMap<Integer, Integer>();
        int n = inorder.length;
        for(int i=0; i<n; i++){
            ioMap.put(inorder[i], i);
        }
        return constBT(inorder, postorder, 0, n-1, 0, n-1);
    }
}