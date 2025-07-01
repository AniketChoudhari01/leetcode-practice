class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //assuming that there are multiple rotten oranges
        //multi source bfs
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int pair[] = q.poll();
                int a = pair[0], b = pair[1];
                //check top
                if(a-1 >= 0 && !visited[a-1][b] && grid[a-1][b] == 1){
                    visited[a-1][b] = true;
                    q.offer(new int[]{a-1, b});
                }
                //check right
                if(b+1 < n && !visited[a][b+1] && grid[a][b+1] == 1){
                    visited[a][b+1] = true;
                    q.offer(new int[]{a, b+1});
                }
                //check bottom
                if(a+1 < m && !visited[a+1][b] && grid[a+1][b] == 1){
                    visited[a+1][b] = true;
                    q.offer(new int[]{a+1, b});
                }
                //check left
                if(b-1 >= 0 && !visited[a][b-1] && grid[a][b-1] == 1){
                    visited[a][b-1] = true;
                    q.offer(new int[]{a, b-1});
                }
            }
            // for(int arr[]:q){
            //     System.out.println(Arrays.toString(arr));
            // }
            // System.out.println();
            if(!q.isEmpty()) minutes++;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]) return -1;
            }
        }
        return minutes;
    }
}