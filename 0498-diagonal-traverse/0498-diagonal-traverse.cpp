class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        //logic is to store the elements based on their sum of indices. for even indices 
        //travel as such when sum is odd, travel it in reverse direction
        vector<vector<int>> traversal(m+n-1);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                traversal[i+j].push_back(mat[i][j]);
            }
        }
        vector<int> ans;
        for(int sum = 0; sum <= m+n-2; sum++){
            //if sum is even traverse as such
            if(sum % 2 != 0){
                for(int k = 0; k< traversal[sum].size(); k++){
                    ans.push_back(traversal[sum][k]);
                }
            }else{
                for(int k = traversal[sum].size()-1; k>=0; k--){
                    ans.push_back(traversal[sum][k]);
                }
            }
            //else travers in reverse direction
        }
        return ans;
    }
};