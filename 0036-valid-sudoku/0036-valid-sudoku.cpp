class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // keep a row map and column map if that elem already found under the
        // map return false and keep a set which will travel with in the 3x3
        // grid and check if the condition is true or false
        vector<unordered_set<int>> rowMap(9);
        vector<unordered_set<int>> colMap(9);
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                // travel a 3x3 grid
                unordered_set<int> grid;
                for (int a = i; a < i + 3; a++) { // 0
                    for (int b = j; b < j + 3; b++) {
                        int curr = board[a][b];
                        if (curr != '.') {
                            // check in row
                            if (rowMap[a].find(curr) != rowMap[a].end() ||
                                colMap[b].find(curr) != colMap[b].end() ||
                                grid.find(curr) != grid.end()) {
                                return false;
                            }

                            rowMap[a].insert(curr);
                            colMap[b].insert(curr);
                            grid.insert(curr);
                        }
                    }
                }
            }
        }
        return true;
    }
};