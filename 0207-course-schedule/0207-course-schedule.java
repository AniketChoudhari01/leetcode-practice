class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //the problem is classic idea of topoloigical sorting
        //we can use the kahn's BFS algorithm to detect if there is any cyclic 
        //dependency in graph
        //step1 : create graph
        int indegree[] = new int[numCourses];
        List<Integer> graph[] = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int edge[]: prerequisites){
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;//also inc indgree of the course who is coming from
        }
        //step2: define Queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int topoLen = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topoLen++;
            for(int neighbor: graph[node]){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        return (topoLen == numCourses);
    }
}