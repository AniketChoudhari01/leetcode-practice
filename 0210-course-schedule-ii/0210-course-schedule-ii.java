class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        //again the problem says if we can detect the cycle and return the topological sorting
        //little bit modification from normal topological sorting
        //here the arrow are arranging in reverse order for conivience
        List<Integer> graph[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        int indegree[] = new int[n];
        for(int edge[]: prerequisites){
            graph[edge[1]].add(edge[0]);//reverse the arrow
            indegree[edge[0]]++;
        }
        int topoSort[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topoSort[idx++] = node;
            for(int neighbor: graph[node]){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        if(idx == n ) return topoSort;
        return new int[]{};
    }
}