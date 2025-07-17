class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int minRectangles = 1;
        Arrays.sort(points, (a,b)-> Integer.compare(a[0], b[0]));
        int curr = points[0][0];
        // for(int point[]: points){
        //     System.out.println(Arrays.toString(point));
        // }
        for(int i=1; i<points.length; i++){
            int x = points[i][0];
            if(x - curr > w){
                minRectangles++;
                curr = x;
            }
        }
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Set<Integer> visited = new HashSet<>();
        // for(int point[]: points){
        //     int x = point[0];
        //     if(!visited.contains(x)){
        //         pq.offer(x);
        //         visited.add(x);
        //     }
        // }
        
        // while(!pq.isEmpty()){
        //     int curr = pq.poll();
        //     while(!pq.isEmpty() && pq.peek() <= curr + w){
        //         pq.poll();
        //     }
        //     minRectangles++;
        // }
        return minRectangles;
    }
}