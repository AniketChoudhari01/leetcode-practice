class Solution {
public:
    vector<vector<int>> sortMatrix(vector<vector<int>>& grid) {
        map<int, vector<int>> map;
        int n = grid.size();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i-j].push_back(grid[i][j]);
            }
        }
        //since the differnce (i-j) is consistent across the diagonals

        for(auto &it: map){
            if(it.first < 0){
                sort(begin(it.second), end(it.second));//in ascending order
            }else{
                sort(begin(it.second), end(it.second), greater<int>());
            }
        }

        //now traverse again from top right corner to bottom left corner to replace the value
        //IMP: here we are removing from back due to less overhead of shifiting the elems if we remove from first
        for(int i = n-1; i>=0; i--){
            for(int j = n-1; j>=0 ;j--){
                grid[i][j] = map[i-j].back();
                map[i-j].pop_back();
            }
        }
        return grid;
    }
};