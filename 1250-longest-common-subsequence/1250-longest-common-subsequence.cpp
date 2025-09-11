class Solution {
public:
    // int isPresent(int l2, int r2, string s2, char ch){
    //     while(l2 <= r2){
    //         if(ch == s2[l2]){
    //             return l2;
    //         }
    //         l2++;
    //     }
    //     return -1;
    // }
    //but we don't need to maintain here r1 and r2 as they are constant
    int dfs(int i, string &s1, int j, string &s2, vector<vector<int>> &dp){
        if(i == s1.size() || j == s2.size()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i] == s2[j]) return dp[i][j] = 1+dfs(i+1, s1, j+1, s2, dp);
        int notTaken1 = 0 + dfs(i+1, s1, j, s2, dp);
        int notTaken2 = 0 + dfs(i, s1, j+1, s2, dp);
        // int idx = isPresent(l2, r2, s2, s1[l1]);
        // if(idx != -1){//current idx l1 char is present in other string between [l2, r2]
        //     taken = 1 + dfs(l1+1, r1, s1, idx+1, r2, s2);
        // }
        return dp[i][j] = max(notTaken1, notTaken2);
    }
    int longestCommonSubsequence(string text1, string text2) {
        int n1 = text1.size();
        int n2 = text2.size();
        // if(n1 > n2) return longestCommonSubsequence(text2, text1);
        vector<vector<int>> dp(n1, vector<int>(n2, -1));
        return dfs(0, text1, 0, text2, dp);
    }
};