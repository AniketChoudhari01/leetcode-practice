import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Build the adjacency list representation of the tree
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        // Create the tree's undirected edges
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Perform DFS to calculate subtree sums and count valid components
        int[] result = new int[1]; // To store the number of valid components
        dfs(0, -1, adjList, values, k, result);
        
        return result[0];
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> adjList, int[] values, int k, int[] result) {
        int subtreeSum = 0; // Start with the value of the current node

        for (int neighbor : adjList.get(node)) {
            if (neighbor != parent) {
                // Recursively calculate the subtree sum for each child
                subtreeSum += dfs(neighbor, node, adjList, values, k, result);
                subtreeSum %=k; //carry left over part
            }
        }

        // If the subtree sum is divisible by k, count it as a valid component and reset the sum
        subtreeSum +=values[node];
        subtreeSum %=k;
        if (subtreeSum == 0) {
            result[0]++; // This is a valid component
        }

        // Otherwise, return the current sum to the parent
        return subtreeSum;
    }
}
