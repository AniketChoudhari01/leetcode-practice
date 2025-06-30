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
    // List<Integer> inorder;
    // private void getInorder(TreeNode root){
    //     if(root == null) return;
    //     getInorder(root.left);
    //     inorder.add(root.val);
    //     getInorder(root.right);
    // }
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        int req = k - root.val;
        if(set.contains(req)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
        // inorder = new ArrayList<>();
        // getInorder(root);
        // int left = 0, right = inorder.size()-1;
        // while(left < right){
        //     int currSum = inorder.get(left) + inorder.get(right) ;
        //     if(currSum == k){
        //         return true;
        //     }else if(currSum < k){
        //         left++;
        //     }else{
        //         right--;
        //     }
        // }
        // return false;
    }
}