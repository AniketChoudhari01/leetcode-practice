class Solution {
    private PriorityQueue<Integer> createPQ(int nums[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int item : nums) {
            pq.offer(item);
        }
        return pq;
    }

    public int findContentChildren(int[] g, int[] s) {
        int contentChildrens = 0;
        PriorityQueue<Integer> child_greed = createPQ(g);
        PriorityQueue<Integer> cookie_size = createPQ(s);
        while (!child_greed.isEmpty() && !cookie_size.isEmpty()) {
            while (!cookie_size.isEmpty() && cookie_size.peek() < child_greed.peek()) {
                cookie_size.poll();
            }
            if (!cookie_size.isEmpty() && cookie_size.peek() >= child_greed.peek()) {
                contentChildrens++;
                child_greed.poll();
                cookie_size.poll();
            }
        }
        return contentChildrens;
    }
}