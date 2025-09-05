class Solution {
public:
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        const int MOD = 1e9+7;
        int n = nums.size();
        int q = queries.size();
        for(auto &query: queries){
            int l = query[0], r = query[1], k = query[2], v = query[3];
            while(l <= r){
                nums[l] = (1LL*(nums[l]%MOD)*(v%MOD))%MOD;
                l += k;
            }
        }
        int xorRes = 0;
        for(int item: nums){
            xorRes ^= item;
        }
        return xorRes;
    }
};