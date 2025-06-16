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
    int maxDist = 0;

    private int findDist(int currNode, Map<Integer, List<Integer>> graph, Set<Integer> seen) {
        seen.add(currNode);
        int currMax = 0;

        for (int neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
            if (!seen.contains(neighbor)) {
                int dist = 1 + findDist(neighbor, graph, seen);
                currMax = Math.max(currMax, dist);
            }
        }

        maxDist = Math.max(maxDist, currMax);
        return currMax;
    }

    private void generateGraph(TreeNode root, Map<Integer, List<Integer>> adjMap) {
        if (root == null)
            return;
        adjMap.putIfAbsent(root.val, new ArrayList<>());
        if (root.left != null) {
            adjMap.putIfAbsent(root.left.val, new ArrayList<>());
            adjMap.get(root.val).add(root.left.val);
            adjMap.get(root.left.val).add(root.val);
            generateGraph(root.left, adjMap);
        }
        if (root.right != null) {
            adjMap.putIfAbsent(root.right.val, new ArrayList<>());
            adjMap.get(root.right.val).add(root.val);
            adjMap.get(root.val).add(root.right.val);
            generateGraph(root.right, adjMap);
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        generateGraph(root, adjMap);
        maxDist = 0;
        Set<Integer> seen = new HashSet<>();
        findDist(start, adjMap, new HashSet<>());
        return maxDist;
    }
}