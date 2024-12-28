class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 1,2,3,4,5,6
        // 1,2,2,3,3,4,5,5,6
        // n-k+1 th from start
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b, a));
        for (int num : nums) {
            maxHeap.add(num);
        }
        while(k-->1){
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}