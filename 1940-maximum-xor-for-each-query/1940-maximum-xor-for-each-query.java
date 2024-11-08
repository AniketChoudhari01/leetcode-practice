class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int xor=0;
        int n=nums.length;
        int maxXOR=(int)(Math.pow(2, maximumBit))-1;
        for(int i=0; i<n; i++){
            xor^=nums[i];
        }
        int ans[]=new int[n];
        for(int i=n-1; i>=0; i--){
            ans[n-i-1]=maxXOR-xor; 
            xor^=nums[i];
        }
        return ans;
    }
}