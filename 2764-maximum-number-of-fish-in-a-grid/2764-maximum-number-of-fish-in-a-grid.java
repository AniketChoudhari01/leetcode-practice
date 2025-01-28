class Solution {
    int m, n;
    private int dfs(int i, int j, int grid[][], boolean visited[][]){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j]==0){
            return 0;
        }
        visited[i][j] = true;
        int left = dfs(i, j-1, grid, visited);
        int top = dfs(i-1, j, grid, visited);
        int right = dfs(i, j+1, grid, visited);
        int bottom = dfs(i+1, j, grid, visited);

        return grid[i][j] + left + right + top + bottom ;
    }
    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxi = 0;
        boolean visited[][] = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j]!=0){
                    maxi = Math.max(maxi, dfs(i, j, grid, visited));
                }
            }
        }
        return maxi;
    }
}