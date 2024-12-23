/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int minOps = 0;

        while (!q.isEmpty()) {
            int level_size = q.size();
            int arr[] = new int[level_size];

            for (int i = 0; i < level_size; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
                arr[i] = node.val;
            }
            int sortedArr[] = Arrays.copyOf(arr, level_size);
            Arrays.sort(sortedArr);
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < level_size; i++) {
                indexMap.put(sortedArr[i], i);
            }

            boolean visited[] = new boolean[level_size];
            for (int i = 0; i < level_size; i++) {
                if (visited[i] || sortedArr[i] == arr[i]) {
                    continue;
                }
                int cycleSize = 0;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = indexMap.get(arr[j]);
                    cycleSize++;
                }
                if (cycleSize > 1) {
                    minOps += (cycleSize - 1);
                }

            }

        }
        return minOps;
    }
}