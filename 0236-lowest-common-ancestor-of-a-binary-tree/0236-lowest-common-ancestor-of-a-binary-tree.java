/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == q || root == p) {
            return root;
        }

        TreeNode isPresentInLeft = findLCA(root.left, p, q);
        TreeNode isPresentInRight = findLCA(root.right, p, q);

        if (isPresentInRight == null) {
            return isPresentInLeft;
        }
        if (isPresentInLeft == null) {
            return isPresentInRight;
        }
        if (isPresentInLeft != null && isPresentInRight != null) {
            return root;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root, p, q);
    }
}