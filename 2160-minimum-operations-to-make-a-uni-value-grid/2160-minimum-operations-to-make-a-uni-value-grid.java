class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[m*n];
        int k =0;
        int prev = grid[0][0] % x;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(prev != (grid[i][j] % x)){
                    return -1;
                }
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int N = arr.length;
        int median = arr[N/2];
        int min_moves = 0;
        for(int num: arr){
            min_moves += (Math.abs(median - num))/x;
        }
        return min_moves;
    }
}