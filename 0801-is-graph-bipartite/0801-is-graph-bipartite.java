class Solution {
    private boolean dfs(int graph[][], int color[], int parent, int curr, int toBeColored) {
        if (color[curr] != 0) {
            if (color[curr] == toBeColored)
                return true;
            return false;
        }
        color[curr] = toBeColored;
        for (int neighbor : graph[curr]) {
            if (neighbor != parent) {
                if (!dfs(graph, color, curr, neighbor, (toBeColored == 1 ? -1 : 1)))
                    return false;
            }

        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {//usedul when there are disconnected components
            if (color[i] == 0) {
                if (!dfs(graph, color, -1, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}