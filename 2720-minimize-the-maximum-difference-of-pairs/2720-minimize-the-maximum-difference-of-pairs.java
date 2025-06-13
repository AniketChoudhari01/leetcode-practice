class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int high = nums[n - 1] - nums[0];
        int low = 0;
        while(low < high){
            int guess = low + (high - low)/2;
            int cnt = 0;
            for(int i=0; i<n-1;){
                if(Math.abs(nums[i]-nums[i+1]) <= guess){
                    cnt++;
                    i += 2;
                }else{
                    i++;
                }
            }
            if(cnt >= p){
                high = guess;
            }else{
                low = guess + 1;
            }
        }
        return low;
    }
}