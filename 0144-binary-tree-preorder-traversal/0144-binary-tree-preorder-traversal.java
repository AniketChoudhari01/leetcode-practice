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
    // private void preOrderTraversal(TreeNode root, List<Integer> preOrder){
    //     if(root == null) return;
    //     preOrder.add(root.val);
    //     preOrderTraversal(root.left, preOrder);
    //     preOrderTraversal(root.right, preOrder);
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if(root == null) return preOrder;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            preOrder.add(node.val);
            if(node.right != null){ // due to FILO princilple of stack
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        return preOrder;
    }
}