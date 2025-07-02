class Solution {
    private void dfs(char [][]board, int i, int j){
        if(i<0 || j< 0 || i>=board.length || j>=board[0].length) return;
        if(board[i][j] != 'O') return;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        board[i][j] = 'N';
        for(int k=0; k<4; k++){
            int x = dx[k] + i;
            int y = dy[k] + j;
            dfs(board, x, y);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        //row 1
        for(int i=0; i<n; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
        }
        //last row 
        for(int i=0; i<n; i++){
            if(board[m-1][i] == 'O'){
                dfs(board, m-1, i);
            }
        }
        //col 1
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
        }
        //last col
        for(int i=0; i<m; i++){
            if(board[i][n-1] == 'O'){
                dfs(board, i, n-1);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'N'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}