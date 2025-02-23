class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)-> (b-a));
        PriorityQueue<Integer> pq;
        long ans = 0;
        for(int i=0; i<m; i++){
            pq = new PriorityQueue<>((a,b)->(b-a));
            for(int j=0; j<n; j++){
                pq.add(grid[i][j]);
            }
            for(int p = 0; p < limits[i]; p++){
                priorityQueue.add(pq.poll());
            }
        }
        for(int p = 0; p < k; p++){
            ans += priorityQueue.poll();
        }
        return ans;
    }
}