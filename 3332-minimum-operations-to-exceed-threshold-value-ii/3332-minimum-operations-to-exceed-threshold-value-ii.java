class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long num: nums){
            if(num < k) pq.add(num);
        }
        int operations = 0;
        while(!pq.isEmpty()){
            long x = pq.poll();
            operations ++;
            if(pq.isEmpty()) break;
            long y = pq.poll();
            long elem = (long)x*2 + y;
            if(elem < k) pq.offer(elem);
        }

        return operations;
    }
}