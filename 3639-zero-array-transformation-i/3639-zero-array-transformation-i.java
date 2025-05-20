class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int difference[] = new int[n+1];
        for(int[] query: queries){
            difference[query[0]]++;
            difference[query[1] + 1]--;
        }
        int sum = 0;
        for(int i=0; i<n+1; i++){
            sum += difference[i];
            difference[i] = sum;
        }
        // System.out.println(Arrays.toString(difference));
        for(int i=0; i<n; i++){
            if(difference[i] < nums[i]){
                return false;
            }
        }
        return true;
    }
}