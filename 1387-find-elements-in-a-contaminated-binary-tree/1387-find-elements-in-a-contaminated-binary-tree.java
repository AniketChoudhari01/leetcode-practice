class FindElements {
    BitSet bitSet;

    public FindElements(TreeNode root) {
        bitSet = new BitSet();
        bitSet.set(0);
        buildTree(root, 0);
    }
    private void buildTree(TreeNode root, int val){
        if(root == null) return;
        root.val = val;
        bitSet.set(val);
        buildTree(root.left, 2*val + 1);
        buildTree(root.right, 2*val + 2);
    }

    public boolean find(int target) {
        return bitSet.get(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */