class Solution {
    Set<Integer> set;

    private boolean detectCycle(int graph[][], boolean visited[], boolean reStack[], int node) {
        if (reStack[node]) 
            return true;
        if (visited[node])
            return false;//no need to explore it
        visited[node] = true;
        reStack[node] = true;
        for (int neighbor : graph[node]) {
            if (detectCycle(graph, visited, reStack, neighbor)) {
                set.add(node);//add the current parent to the recursion stack
                return true;
            }
        }
        reStack[node] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        //find the nodes which are not part of cycle dfs
        set = new HashSet<>();
        boolean visited[] = new boolean[n];
        boolean reStack[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                detectCycle(graph, visited, reStack, i);
            }
        }
        for(int i=0; i<n ; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        // System.out.println(set);
        return ans;
    }
}