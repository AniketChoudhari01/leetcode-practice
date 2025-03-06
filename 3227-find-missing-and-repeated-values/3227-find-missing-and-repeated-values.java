class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n*n;
        int actSum = N*(N+1)/2;
        boolean isSeen[] = new boolean[N+1];
        int sum = 0;
        int repeat = 0, missing = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum += grid[i][j];
                if(isSeen[grid[i][j]]){
                    repeat = grid[i][j];
                }else{
                    isSeen[grid[i][j]] = true;
                }
            }
        }
        missing = actSum - (sum - repeat);
        return new int[]{repeat, missing};
    }
}