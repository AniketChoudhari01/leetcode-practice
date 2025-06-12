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
    class NodeIdxPair{
        int idx ;
        TreeNode node;
        public NodeIdxPair(TreeNode a, int b){
            this.node = a;
            this.idx = b;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        //using bfs
        int maxWidth = 0;
        Queue<NodeIdxPair> q = new ArrayDeque<>();
        NodeIdxPair firstPair = new NodeIdxPair(root, 0);
        q.offer(firstPair);
        while(!q.isEmpty()){
            int size = q.size();
            int minIdx = 0, maxIdx = 0;
            for(int i=0; i<size; i++){
                NodeIdxPair pair = q.poll();
                if(i == 0) minIdx = pair.idx;
                if(i == size - 1) maxIdx = pair.idx;
                if(pair.node.left != null){
                    NodeIdxPair p = new NodeIdxPair(pair.node.left, 2*pair.idx + 1);
                    q.offer(p);
                }
                if(pair.node.right != null){
                    NodeIdxPair p = new NodeIdxPair(pair.node.right, 2*pair.idx + 2);
                    q.offer(p);
                }
            }
            maxWidth = Math.max(maxWidth, maxIdx - minIdx + 1);
        }
        return maxWidth;
    }
}