class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int minRectangles = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        for(int point[]: points){
            int x = point[0];
            if(!visited.contains(x)){
                pq.offer(x);
                visited.add(x);
            }
        }
        
        while(!pq.isEmpty()){
            int curr = pq.poll();
            while(!pq.isEmpty() && pq.peek() <= curr + w){
                pq.poll();
            }
            minRectangles++;
        }
        return minRectangles;
    }
}