class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        boolean flip = false; // l->r move
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new ArrayList<>();

            Deque<TreeNode> tempQ = new ArrayDeque<>();
            TreeNode parent;

            for (int i = 0; i < size; i++) {
                if (!flip) {
                    parent = q.pollFirst();
                } else {
                    parent = q.pollLast();
                }
                li.add(parent.val);
                if (!flip) {
                    if (parent.left != null) {
                        tempQ.offerLast(parent.left);
                    }
                    if (parent.right != null) {
                        tempQ.offerLast(parent.right);
                    }
                } else {
                    if (parent.right != null) {
                        tempQ.offerFirst(parent.right);
                    }
                    if (parent.left != null) {
                        tempQ.offerFirst(parent.left);
                    }
                }
            }
            flip = !flip;
            q = new ArrayDeque<>(tempQ);
            ansList.add(li);
        }
        return ansList;
    }
}