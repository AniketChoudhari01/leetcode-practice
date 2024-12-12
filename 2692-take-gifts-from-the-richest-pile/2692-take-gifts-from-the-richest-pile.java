class Solution {
    public long pickGifts(int[] gifts, int k) {
        long res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            Comparator.reverseOrder()
        );
        for(int gift: gifts){ 
            pq.add(gift);
        }
        while(k-->0 && !pq.isEmpty()){
            int polled=(int)Math.sqrt(pq.poll());
            if(polled>0)
                pq.offer(polled);
        }
        while(!pq.isEmpty()){
            res+=pq.poll();
        }
        return res;
    }
}