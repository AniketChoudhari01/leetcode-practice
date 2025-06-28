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
class BSTIterator {
    private List<TreeNode> list;
    private int idx;
    private void inorderTraversal(TreeNode root){
        if(root == null) return;
        inorderTraversal(root.left);
        list.add(new TreeNode(root.val));
        inorderTraversal(root.right);
    }
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorderTraversal(root);
        for(TreeNode node:list) System.out.println(node.val);
        idx = 0;
    }
    
    public int next() {
        if(idx > list.size()){
            return -1;
        }
        return list.get(idx++).val;
    }
    
    public boolean hasNext() {
        return idx < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */