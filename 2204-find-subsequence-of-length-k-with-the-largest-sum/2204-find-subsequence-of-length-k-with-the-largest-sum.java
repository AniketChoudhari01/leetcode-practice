class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Arrays.sort(nums, Collections.reverseOrder());
        //reversing works only for primitive data type like Integer[], because Collections.reverseOrder() requires object that implements comparable method.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int elem: nums){
            pq.offer(elem);
            while(pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        int len = k;
        Map<Integer, Integer> hm = new HashMap<>();
        while(k-- > 0){
            int item = pq.poll();
            hm.put(item, hm.getOrDefault(item, 0)+1);
        }
        int idx = 0;
        int res[] = new int[len];
        for(int l=0; l<nums.length; l++){
            if(hm.containsKey(nums[l]) && hm.get(nums[l]) > 0){
                res[idx++] = nums[l];
                hm.put(nums[l], hm.get(nums[l])-1);
            }
        }
        return res;
    }
}