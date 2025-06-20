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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode currNode = root;
        // st.push(currNode);
        while(!st.isEmpty() || currNode != null){
            while(currNode != null){
                st.push(currNode);
                currNode = currNode.left;
            }
            TreeNode node = st.pop();
            list.add(node.val);
            if(node.right != null){
                currNode = node.right;
            }
        }
        return list;
    }
}