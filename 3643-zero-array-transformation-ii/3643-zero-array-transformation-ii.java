class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        //using the concept of line sweep algorithm
        int n = nums.length;
        int d[] = new int[n+1];//difference array
        int k = 0, sum = 0;//num of required queries
        for(int i=0; i<n; i++){
            while(sum + d[i] < nums[i]){
                if(k == queries.length) return -1;//reached end 
                int l = queries[k][0];
                int r = queries[k][1];
                int val = queries[k][2];
                k++;
                if(r < i) continue;

                d[Math.max(l, i)] += val;
                d[r + 1] -= val;
            }
            sum += d[i];
        }
        return k;
    }
}