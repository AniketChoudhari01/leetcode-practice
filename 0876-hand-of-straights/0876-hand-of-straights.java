class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if((n % groupSize) != 0) return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int item: hand){
            map.put(item, map.getOrDefault(item, 0)+1);
        }
        for(Map.Entry<Integer, Integer> pair: map.entrySet()){
            pq.offer(pair.getKey());
        }
        List<Integer> list;
        while(!pq.isEmpty()){
            int size = groupSize;
            int prev = pq.peek() - 1;
            list = new ArrayList<>();
            while(size-- > 0){
                int curr = pq.poll();
                if(prev + 1 != curr){
                    return false;
                }
                if(map.get(curr) > 1){
                    map.put(curr, map.get(curr) - 1);
                    list.add(curr);
                }
                prev = curr;
                if(size != 0 && pq.isEmpty()) return false;
            }
            // if(size != 0) return false;
            for(int item: list){
                pq.add(item);
            }
        }
        return true;
    }
}