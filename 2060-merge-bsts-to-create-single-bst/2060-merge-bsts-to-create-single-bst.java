class Solution {
    private Map<Integer, TreeNode> rootMap = new HashMap<>();

    private TreeNode merge(TreeNode root) {
        if (root == null) return null;

        // If the current node is a root in the map, replace it and merge its children
        if (rootMap.containsKey(root.val)) {
            TreeNode toMerge = rootMap.remove(root.val);
            toMerge.left = merge(toMerge.left);
            toMerge.right = merge(toMerge.right);
            return toMerge;
        }

        root.left = merge(root.left);
        root.right = merge(root.right);
        return root;
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public TreeNode canMerge(List<TreeNode> trees) {
        Set<Integer> leafVals = new HashSet<>();
        for (TreeNode tree : trees) {
            if (tree.left != null) leafVals.add(tree.left.val);
            if (tree.right != null) leafVals.add(tree.right.val);
        }

        TreeNode mainRoot = null;
        for (TreeNode tree : trees) {
            if (!leafVals.contains(tree.val)) {
                if (mainRoot != null) return null; // more than one root
                mainRoot = tree;
            }
            rootMap.put(tree.val, tree);
        }

        if (mainRoot == null) return null;

        // Remove the root from map to avoid merging it into itself
        rootMap.remove(mainRoot.val);

        TreeNode merged = merge(mainRoot);

        if (!rootMap.isEmpty()) return null; // not all trees were merged

        return isValidBST(merged, Long.MIN_VALUE, Long.MAX_VALUE) ? merged : null;
    }
}
