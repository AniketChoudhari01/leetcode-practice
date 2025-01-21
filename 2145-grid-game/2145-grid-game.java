class Solution {
    public long gridGame(int[][] grid) {
        int m = 2;
        int n = grid[0].length;
        long prefixSum1[] = new long[n];
        long prefixSum2[] = new long[n];
        long cnt1 = 0;
        long cnt2 = 0;
        for(int i=0;i<n; i++){
            cnt1 += grid[0][i];
            cnt2 += grid[1][i];
            prefixSum1[i] = cnt1;
            prefixSum2[i] = cnt2;
        }
        long temp1[] = new long[n];
        long temp2[] = new long[n];
        for(int i=0; i<n; i++){
            temp1[i]=(prefixSum1[n-1]- prefixSum1[i]);
            temp2[i] = (i>0? (prefixSum2[i-1]):0);
        }
        for(int i=0; i<n; i++){
            temp1[i] = Math.max(temp1[i], temp2[i]);
        }
        long mini=Long.MAX_VALUE;
        for(long num:temp1){
            mini = Math.min(mini, num );
        }

        return mini;
    }
}