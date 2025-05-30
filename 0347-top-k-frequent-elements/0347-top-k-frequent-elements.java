class Solution {
    class Pair {
        int freq, elem;

        public Pair(int freq, int elem) {
            this.freq = freq;
            this.elem = elem;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.freq, a.freq));
        for(Map.Entry<Integer, Integer> item: map.entrySet()){
            Pair pair = new Pair(item.getValue(), item.getKey());
            pq.offer(pair);
        }

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            Pair pair = pq.poll();
            ans[i] = pair.elem;
        }
        return ans;
    }
}