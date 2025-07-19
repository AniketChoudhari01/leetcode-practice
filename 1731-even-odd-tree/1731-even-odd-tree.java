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
    public boolean isEvenOddTree(TreeNode root) {
        //step1: define the queue ds
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int prev = -1;
            //traversal in level
            int curr = -1;
            while (size-- > 0) {
                TreeNode parentNode = q.poll();
                curr = parentNode.val;
                if (prev == -1) {//not initialised first
                    if(level%2 == 0 && curr%2==0){
                        return false;
                    }
                    if(level%2 != 0 && curr % 2 != 0){
                        return false;
                    }
                    prev = curr;
                } else if (level % 2 == 0) {
                    if (curr % 2 == 0 || curr <= prev) {
                        return false;
                    }
                    prev = curr;
                } else {//level odd
                    if (curr % 2 != 0 || curr >= prev) {
                        return false;
                    }
                    prev = curr;
                }
                if (parentNode.left != null) {
                    // curr = parentNode.left.val;
                    q.offer(parentNode.left);
                }
                if(parentNode.right != null){
                    q.offer(parentNode.right);
                }
                // if (parentNode.right != null) {
                //     curr = parentNode.right.val;
                //     if (prev == -1) {//not initialised first
                //         prev = parentNode.val;
                //     } else if (level % 2 == 0) {
                //         if (curr % 2 != 0 || curr <= prev) {
                //             return false;
                //         }
                //         prev = curr;
                //     } else {
                //         if (curr % 2 != 0 || curr >= prev) {
                //             return false;
                //         }
                //         prev = curr;
                //     }
                //     q.offer(parentNode.right);
                // }
            }
            level++;
        }
        return true;
    }
}