class Solution {
    char sum;
    boolean visited[][];
    private void assignId(char [][] grid, int i, int j){
        if(i<0 || j<0 ||i >= grid.length || j>= grid[0].length){
            return;
        }
        if(grid[i][j] == '0') return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        grid[i][j] = sum;

        assignId(grid, i, j+1);//move right     
        assignId(grid, i+1, j);//move bottom
        assignId(grid, i, j-1);//move left
        assignId(grid, i-1, j);//move up
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        sum = '2';
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] !='0'){
                    assignId(grid, i, j);
                    sum++;
                }
            }
        }
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != '0' && !set.contains(grid[i][j])){
                    set.add(grid[i][j]);
                }
            }
        }
        return set.size();
    }
}