class Solution {
    private void dfs(int i, int j, int [][]grid){
        if(i < 0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] !=1) return;
        grid[i][j] = -1;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        for(int m=0; m<4; m++){
            int x = i + dx[m];
            int y = j + dy[m];
            dfs(x, y, grid);
        }
    }
    public int numEnclaves(int[][] grid) {
        //step 1:find the corner elements and from them consider them as a src of dfs
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<n; i++){
            if(grid[0][i] == 1){
                dfs(0, i, grid);//first row
            }
            if(grid[m-1][i] == 1){
                dfs(m-1, i, grid);//last row
            }
        }
        for(int i=0; i<m; i++){
            if(grid[i][0] == 1){
                dfs(i, 0, grid);//first column
            }
            if(grid[i][n-1] == 1){
                dfs(i, n-1, grid);//last column
            }
        }
        // for(int a[]: grid){
        //     System.out.println(Arrays.toString(a));
        // }
        int enclaves = 0;
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 1){
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
}