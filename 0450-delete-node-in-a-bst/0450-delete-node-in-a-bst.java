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
    private TreeNode[] searchNode(TreeNode parent, TreeNode child, int key) {
        if (child == null)
            return new TreeNode[] { null, null };
        if (child.val == key) {
            return new TreeNode[] { parent, child };
        }
        if (child.val < key) {
            return searchNode(child, child.right, key);
        }
        if (child.val > key) {
            return searchNode(child, child.left, key);
        }
        return new TreeNode[] { parent, child };
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.val == key && root.left == null && root.right == null))
            return null;
        if (root.val == key) {
            if (root.right == null)
                return root.left;
            TreeNode currNode = root.right;
            while (currNode.left != null) {
                currNode = currNode.left;
            }
            currNode.left = root.left;
            return root.right;
        }
        TreeNode[] store = searchNode(root, root, key);
        TreeNode parent = store[0];
        TreeNode deleteNode = store[1];
        if (parent == null)
            return root;
        // System.out.println(parent.val);
        // System.out.println(deleteNode.val);
        //delete the node;
        if (deleteNode.left == null && deleteNode.right == null) {
            if (parent.left == deleteNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (deleteNode.right != null) {
            TreeNode temp = deleteNode.right;
            if (deleteNode == parent.left) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = deleteNode.left;
        } else {
            if (parent.left == deleteNode) {
                parent.left = deleteNode.left;
            } else {
                parent.right = deleteNode.left;
            }
        }

        return root;
    }
}