class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int limit;
    public KthLargest(int k, int[] nums) {
        limit = k;
        for(int item: nums){
            pq.offer(item);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > limit){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */