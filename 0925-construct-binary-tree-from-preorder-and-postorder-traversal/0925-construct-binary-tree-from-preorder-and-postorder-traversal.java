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
    HashMap<Integer, Integer> post_indx;
    private TreeNode buildTree(int i1, int i2, int j1, int j2, int []preorder, int []postorder){
        if(i1>i2 || j1>j2){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i1]);
        if(i1 != i2){
            int left_val = preorder[i1+1];
            int mid = post_indx.get(left_val);
            int left_size = mid - j1 + 1;
            root.left = buildTree(i1+1, i1+left_size, j1, mid, preorder, postorder);
            root.right = buildTree(i1+left_size+1, i2, mid+1, j2-1, preorder, postorder);
        }
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        post_indx = new HashMap<>();
        int n = preorder.length;
        for(int i=0; i<postorder.length; i++){
            post_indx.put(postorder[i], i);
        }
        return buildTree(0, n-1, 0, n-1, preorder, postorder);
    }
}