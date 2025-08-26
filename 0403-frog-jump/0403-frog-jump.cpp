class Solution {
private:
    // bool reached = false;
    bool dfs(vector<int>& stones, int idx, int k, unordered_map<int, int>& map,
             vector<vector<int>>& dp) {
        // dp
        // I have to check with the
        if (idx >= stones.size() - 1) {
            // reached = true;
            return true;
        }
        if (dp[idx][k] != -1)
            return dp[idx][k];
        // bool isPossible = false;
        for (int i = k - 1; i <= k + 1; i++) { // here k represents the previous
                                               // jump from which it came here
            if (i == 0) { // try all possible jump
                continue;
            }
            if (map.find(stones[idx] + i) != map.end()) {
                int nextIdx = map[stones[idx] + i];
                if (nextIdx > idx && dfs(stones, nextIdx, i, map, dp)) {
                    return dp[idx][k] = true;
                    // return true;
                }
            }
        }
        return dp[idx][k] = false;
    }

public:
    bool canCross(vector<int>& stones) {
        unordered_map<int, int> map;
        int n = stones.size();
        vector<vector<int>> dp(n,
                               vector<int>(n + 1, -1)); // dimensions ={idx, k};
        if (stones[0] + 1 < stones[1])
            return false;
        for (int i = 1; i < stones.size(); i++) {
            map[stones[i]] = i;
        }
        return dfs(stones, 1, 1, map, dp);
        // return reached == true;
        //[0,1,2,3,4,5,6,12]
        // 1, 1,2 -> 1
        // 2
    }
};