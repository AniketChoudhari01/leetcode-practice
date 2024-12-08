
class Solution {
    public int maxTwoEvents(int[][] events) {
        
        PriorityQueue<Pair<Integer, Integer>> pq=new PriorityQueue<>(
            Comparator.comparingInt(Pair::getKey)
        );
        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return Integer.compare(a[0], b[0]);
            }
        });

        int maxValue=0;
        int maxSum=0;
        for(int[] event: events){
            while(!pq.isEmpty() && pq.peek().getKey()<event[0]){
                maxValue=Math.max(maxValue, pq.peek().getValue());
                pq.poll();
            }
            maxSum=Math.max(maxSum, maxValue+event[2]);
            pq.add(new Pair<>(event[1], event[2]));
        }

        return maxSum;
    }
}
