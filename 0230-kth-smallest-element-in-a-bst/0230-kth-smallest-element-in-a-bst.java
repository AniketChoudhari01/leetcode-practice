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
    public void dfs(TreeNode root, int k, PriorityQueue<Integer> pq) {
        if (root == null)
            return ;
        pq.offer(root.val);
        dfs(root.left, k, pq);
        dfs(root.right, k, pq);
    }

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dfs(root, k, pq);
        int ans = -1;
        while(k-- > 0){
            ans = pq.poll();
        }
        return ans;
    }
}