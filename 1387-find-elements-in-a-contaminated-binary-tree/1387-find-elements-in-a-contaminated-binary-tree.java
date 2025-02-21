class FindElements {
    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        // level order traversal
        Queue<TreeNode> queue = new ArrayDeque<>();
        root.val = 0;
        queue.add(root);
        set.add(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int x = node.val;
            if (node.left != null) {
                node.left.val = 2 * x + 1;
                queue.offer(node.left);
                set.add(2 * x + 1);
            }
            if (node.right != null) {
                node.right.val = 2 * x + 2;
                queue.offer(node.right);
                set.add(2 * x + 2);
            }
        }
    }

    public boolean find(int target) {
        if (set.contains(target))
            return true;
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */