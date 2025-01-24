class Solution {
    private void dfs(int src, boolean[] visited, boolean[] inStack, int[] edges, int[] maxi) {
        visited[src] = true;
        inStack[src] = true;

        int next = edges[src];
        if (next != -1) { // Check if there's an edge from the current node
            if (!visited[next]) {
                dfs(next, visited, inStack, edges, maxi);
            } else if (inStack[next]) { // Cycle detected
                int cycleSize = 1;
                int current = next;
                while (edges[current] != next) {
                    cycleSize++;
                    current = edges[current];
                }
                maxi[0] = Math.max(maxi[0], cycleSize);
            }
        }

        inStack[src] = false; 
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        int[] maxi = { -1 }; 

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, inStack, edges, maxi);
            }
        }

        return maxi[0];
    }
}
