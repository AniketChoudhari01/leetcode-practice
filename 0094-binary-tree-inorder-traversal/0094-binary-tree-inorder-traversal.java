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
    // private void inOrderTraversal(TreeNode root, List<Integer> li){
    //     if(root == null) return;
    //     inOrderTraversal(root.left, li);
    //     li.add(root.val);
    //     inOrderTraversal(root.right, li);
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode currNode = root;
        while(!st.isEmpty() || currNode != null){
            while(currNode != null){
                st.push(currNode);
                currNode = currNode.left;
            }
            TreeNode node = st.pop();
            inOrder.add(node.val);
            
            currNode = node.right;
        }
        return inOrder;
    }
}