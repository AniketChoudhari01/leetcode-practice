class Solution {
    private int dijikstras(List<int[]> graph[], int n, int k) {
        int dist[] = new int[n + 1];
        int maxi = (int) 1e9;
        Arrays.fill(dist, maxi);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { 0, k });
        while (!pq.isEmpty()) {
            int item[] = pq.poll();
            int currDist = item[0];
            int node = item[1];

            for (int neighbor[] : graph[node]) {
                if (currDist + neighbor[1] < dist[neighbor[0]]) {//dist + wgt < dist[already]
                    dist[neighbor[0]] = currDist + neighbor[1];
                    pq.offer(new int[] { dist[neighbor[0]], neighbor[0] });
                }
            }
        }
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxi)
                return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        //first idea is to find the shortest path of all nodes from source node.
        //then travel over the shortest path array and return the answer;
        List<int[]> graph[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        } //initalize the graph
        for (int time[] : times) {
            graph[time[0]].add(new int[] { time[1], time[2] });
        }
        //print graph
        // for(List<int[]> li:graph){
        //     for(int item[]: li){
        //         System.out.println(Arrays.toString(item));
        //     }
        // }
        //dijikstras algorithm
        return dijikstras(graph, n, k);
    }
}