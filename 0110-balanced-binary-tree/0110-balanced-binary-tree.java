class Solution {
    public boolean isBalanced;
    private int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int difference = Math.abs(leftHeight - rightHeight);
        // System.out.println("l: "+leftHeight+" ,r: "+rightHeight+" diff: "+difference);
        if(isBalanced && difference > 1){
            isBalanced = false;
        }
        return 1 + Math.max(leftHeight , rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        } 
        isBalanced = true;
        int height = findHeight(root);
        return isBalanced;
    }
}