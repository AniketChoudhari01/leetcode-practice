class Solution {
    private boolean validIdx(int i, int j, int m , int n){
        if(i < 0 || j<0 || i>=m || j>=n) return false;
        return true;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();//{dist, {i, j}}//1X3
        q.offer(new int[]{0,0,0});
        int dist[][] = new int[m][n];
        int maxi = (int)1e9;
        for(int d[]:dist){
            Arrays.fill(d, maxi);
        }
        dist[0][0] = 1;
        while(!q.isEmpty()){
            int item[] = q.poll();
            int d = item[0];
            int i = item[1];
            int j = item[2];
            if(i == m-1 && j == n-1){
                return d+1;
            }
            //explore all 8 dirs
            if(validIdx(i, j+1, m, n) && grid[i][j+1] != 1 && (d + 1 < dist[i][j+1])){
                dist[i][j+1] = 1 + d;
                q.offer(new int[]{dist[i][j+1],i, j+1});
            }//right
            if(validIdx(i+1, j+1, m, n) && grid[i+1][j+1] != 1 && (d + 1 < dist[i+1][j+1])){
                dist[i+1][j+1] = 1 + d;
                q.offer(new int[]{dist[i+1][j+1],i+1, j+1});
            }//downRight
            if(validIdx(i+1, j, m, n) && grid[i+1][j] != 1 && (d + 1 < dist[i+1][j])){
                dist[i+1][j] = 1 + d;
                q.offer(new int[]{dist[i+1][j],i+1, j});
            }//down
            if(validIdx(i+1, j-1, m, n) && grid[i+1][j-1] != 1 && (d + 1 < dist[i+1][j-1])){
                dist[i+1][j-1] = 1 + d;
                q.offer(new int[]{dist[i+1][j-1],i+1, j-1});
            }//downLeft
            if(validIdx(i, j-1, m, n) && grid[i][j-1] != 1 && (d + 1 < dist[i][j-1])){
                dist[i][j-1] = 1 + d;
                q.offer(new int[]{dist[i][j-1],i, j-1});
            }//left
            if(validIdx(i-1, j-1, m, n) && grid[i-1][j-1] != 1 && (d + 1 < dist[i-1][j-1])){
                dist[i-1][j-1] = 1 + d;
                q.offer(new int[]{dist[i-1][j-1],i-1, j-1});
            }//topLeft
            if(validIdx(i-1, j, m, n) && grid[i-1][j] != 1 && (d + 1 < dist[i-1][j])){
                dist[i-1][j] = 1 + d;
                q.offer(new int[]{dist[i-1][j],i-1, j});
            }//top
            if(validIdx(i-1, j+1, m, n) && grid[i-1][j+1] != 1 && (d + 1 < dist[i-1][j+1])){
                dist[i-1][j+1] = 1 + d;
                q.offer(new int[]{dist[i-1][j+1],i-1, j+1});
            }//topRight
        }
        // if(dist[m-1][n-1] == maxi){
        //     return -1;
        // }
        // for(int a[]:dist){
        //     System.out.println(Arrays.toString(a));
        // }
        return -1;
    }
}