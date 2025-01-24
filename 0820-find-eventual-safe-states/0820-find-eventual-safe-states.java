class Solution {

    private boolean elemsInCycle(int src, boolean recursionStack[], boolean visited[], int[][] graph,
            boolean notSafe[]) {
        if (!visited[src] && (graph[src].length > 0) && !notSafe[src]) {
            visited[src] = true;
            recursionStack[src] = true;
            for (int v : graph[src] ) {
                if (!visited[v] && elemsInCycle(v, recursionStack, visited, graph, notSafe)) {
                    notSafe[src] = true;
                    return true;
                } else if (recursionStack[v]) {
                    notSafe[src] = true;
                    return true;
                }
            }
        }

        recursionStack[src] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        boolean recursionStack[] = new boolean[m];
        boolean notSafe[] = new boolean[m];
        boolean visited[] = new boolean[m];
        List<Integer> terminalSrc = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            if (!visited[i] && elemsInCycle(i, recursionStack, visited, graph, notSafe)) {
                notSafe[i] = true;
            }
        }
        for(int i = 0; i< m; i++){
            if(!notSafe[i]){
                terminalSrc.add(i);
            }
        }
        // System.out.println(Arrays.toString(notSafe));
        return terminalSrc;
    }
}