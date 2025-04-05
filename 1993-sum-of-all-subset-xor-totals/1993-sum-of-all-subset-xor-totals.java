class Solution {
    int xor;
    private void findSubsets(int nums[], int i, int ans){
        if(i == nums.length){
            return;
        }
        ans = ans^nums[i];
        findSubsets(nums, i+1, ans);//1, (1,3): 
        xor += ans;
        ans ^= nums[i];
        findSubsets(nums, i+1, ans);
    }
    public int subsetXORSum(int[] nums) {
        //in each subset how many times that number provides its contribution
        //if even nullifed effect
        //(3), (3,4), (3,4,5),(3,4,5,6), (3,4,5,6,7), (3,4,5,6,7,8)
        //(4), (4,5), (4,5,6), (4,5,6,7), (4,5,6,7,8)
        //(5), (5,6), (5,6,7), (5,6,7,8)
        findSubsets(nums, 0, 0);      
        return xor;
    }
}