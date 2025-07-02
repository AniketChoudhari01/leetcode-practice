class Solution {
    // private int dfs(int mat[][], int ans[][], int i, int j, boolean visited[][]){
    //     if(i < 0 || j < 0 || i>= mat.length || j>= mat[0].length || visited[i][j]) return Integer.MAX_VALUE;
    //     if(mat[i][j] == 0) return 0;
    //     if(ans[i][j] != -1){
    //         return ans[i][j];
    //     }
    //     int dx[] = {-1, 0, 1, 0};
    //     int dy[] = {0, 1, 0, -1};
    //     visited[i][j] = true;
    //     int mini = Integer.MAX_VALUE;
    //     for(int m=0; m<4; m++){
    //         int p = i + dx[m];
    //         int q = j + dy[m];
    //         int curr = dfs(mat, ans, p, q, visited);
    //         mini = Math.min(mini, curr);
    //         if(mini < 0) mini = 0;
    //         System.out.println(p+" "+q+" curr: "+curr);
    //     }
    //     return (ans[i][j] = mini + 1);
    // }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[][] = new int[m][n];
        //step 1: fill the answer array with -1 
        for(int arr[]: ans){
            Arrays.fill(arr, -1);
        }
        // boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        //step 2: put all the valid BFS origin in the queue multi source 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j, 0});
                    ans[i][j] = 0;
                }
            }
        }
        //step 3: initialise all the four possible directions
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int node[] = q.poll();
            for(int i=0; i<4; i++){
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];
                //the main logic here is if we reach 1 and if it not been updated by any other 
                //source means curr source has the shortes distance from it.
                //update it's answer and further make it as a source and put it in the queue.
                // 0 0 0 
                // 0 1 0 -> in this center one will work as a src and provide ans to the next row 1
                // 1 1 1
                if(x >= 0 && y >=0 && x < m && y < n && ans[x][y] == -1){
                    ans[x][y] = node[2] + 1;
                    q.offer(new int[]{x, y, ans[x][y]});
                }
            }
        }
        return ans;
    }
}