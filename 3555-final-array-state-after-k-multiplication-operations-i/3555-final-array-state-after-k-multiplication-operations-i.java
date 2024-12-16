class Solution {
    class numsIndex{
        int num;
        int ind;
        public numsIndex(int num, int ind){
            this.num = num;
            this.ind = ind;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<numsIndex> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.num != b.num){
                    return Integer.compare(a.num, b.num);
                }else{
                    return Integer.compare(a.ind, b.ind);
                }
            }
        );
        for(int i=0; i<nums.length; i++){
            pq.offer(new numsIndex(nums[i], i));
        }

        while(k-->0 && !pq.isEmpty()){
            numsIndex ni = pq.poll();
            int item = (nums[ni.ind]*multiplier);
            nums[ni.ind] = item;
            pq.offer(new numsIndex(item, ni.ind));
        }
        return nums;
    }
}