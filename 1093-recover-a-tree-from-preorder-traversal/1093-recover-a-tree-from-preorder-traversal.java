/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int i = 0;

    private int findDigit(String str) {
        int digit = 0;
        while (i < str.length() && str.charAt(i) != '-') {
            digit = digit * 10 + (str.charAt(i) - '0');
            i++;
        }
        return digit;
    }

    private int findLevel(String str) {
        int level = 0;
        while (i < str.length() && str.charAt(i) == '-') {
            level++;
            i++;
        }
        return level;
    }

    private TreeNode buildTree(String str) {
 
        int digit = findDigit(str);
        TreeNode root = new TreeNode(digit);
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (i < str.length()) {
            int level = findLevel(str);
            int value = findDigit(str);
            while (st.size() > level) {
                st.pop();
            }
            TreeNode node = new TreeNode(value);
            TreeNode parent = st.peek();
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            st.push(node);
        }
        return root;
    }

    public TreeNode recoverFromPreorder(String str) {
        return buildTree(str);
    }
}