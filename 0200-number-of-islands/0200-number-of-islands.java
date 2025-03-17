class Solution {
    private void assignId(char [][] grid, int i, int j){
        if(i<0 || j<0 ||i >= grid.length || j>= grid[0].length){
            return;
        }
        if(grid[i][j] != '1') return;
        grid[i][j] = 'A';

        assignId(grid, i, j+1);//move right     
        assignId(grid, i+1, j);//move bottom
        assignId(grid, i, j-1);//move left
        assignId(grid, i-1, j);//move up
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0 ;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] =='1'){
                    ans++;
                    assignId(grid, i, j);
                }
            }
        }
        return ans;
    }
}