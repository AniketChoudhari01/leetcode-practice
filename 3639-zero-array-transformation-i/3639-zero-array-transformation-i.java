class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int difference[] = new int[n+1];
        for(int i=0; i<queries.length; i++){
            difference[queries[i][0]]++;
            difference[1 + queries[i][1]]--;
        }
        System.out.println(Arrays.toString(difference));
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += difference[i];//prefix sum
            if(sum < nums[i]) return false;
        }
        return true;
    }
}