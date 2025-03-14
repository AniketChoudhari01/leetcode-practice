class Solution {
    private boolean isMinPenalty(int penalty, int nums[], int maxOprs){
        int cnt = 0;
        for(int num: nums){
            // cnt += Math.ceil(num/(double)penalty)-1; //take care of int/int division and also -1 since with one operation we can divide the bag into 2 bags
            cnt += (num -1 )/penalty;
            if(cnt > maxOprs) return false;
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOprs) {
        int low = 1;
        int high = 1;
        for(int num: nums){
            high = Math.max(high, num);
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isMinPenalty(mid, nums, maxOprs)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}