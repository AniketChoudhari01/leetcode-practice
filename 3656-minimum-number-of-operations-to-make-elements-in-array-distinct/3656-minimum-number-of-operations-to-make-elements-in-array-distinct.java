class Solution {
    private boolean isDistinct(int freq[]){
        int n = freq.length;
        for(int item: freq){
            if(item > 1){
                return false;
            }
        }
        return true;
    }
    public int minimumOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int freq[] = new int[101];
        for(int item: nums){
            freq[item]++;
        }
        if(isDistinct(freq)) return 0;
        for(int i=0; i<n; ){
            int j=i;
            boolean valid = true;
            while(j < n && j < i + 3){
                freq[nums[j]]--;
                if(freq[nums[j]] > 1){
                    valid = false;
                }else{
                    valid = true;
                }
                j++;
            }
            ans++;
            if(valid && isDistinct(freq)){
                return ans;
            }
            i = j;
        }
        return ans;
    }
}