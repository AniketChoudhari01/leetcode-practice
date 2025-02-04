class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int total = 0;
        for(int i=0; i< n; i++){
            if(nums[i] % 2 != 0){
                nums[i] = 1;
            }else{
                nums[i] = 0;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        for(int i=0; i<n; i++){
            currSum += nums[i];
            if(map.containsKey(currSum - k)){
                total += map.get(currSum - k);
            }
            if(currSum == k){
                total++;
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return total;
    }
}