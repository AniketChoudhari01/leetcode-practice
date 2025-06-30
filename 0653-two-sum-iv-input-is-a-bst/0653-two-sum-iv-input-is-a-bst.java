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
    private void getInorder(TreeNode root){
        if(root == null) return;
        getInorder(root.left);
        inorder.add(root.val);
        getInorder(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        inorder = new ArrayList<>();
        getInorder(root);
        int left = 0, right = inorder.size()-1;
        while(left < right){
            int currSum = inorder.get(left) + inorder.get(right) ;
            if(currSum == k){
                return true;
            }else if(currSum < k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}