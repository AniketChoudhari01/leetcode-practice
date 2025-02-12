
class Solution {
    private int findDepth(TreeNode root, int maxi){
        if(root == null){
            return 0;
        }
        return maxi =  1 + Math.max(maxi, Math.max(findDepth(root.left, maxi), findDepth(root.right, maxi)));
    }
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0);
    }
}