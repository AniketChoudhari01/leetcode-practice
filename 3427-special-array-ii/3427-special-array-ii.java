class Solution {

    private boolean binarySearch(int start, int end, List<Integer> voilatingIndices){
        int low=0;
        int high= voilatingIndices.size()-1;
        while(low<=high){
            int mid= (low+high)/2;
            int violating = voilatingIndices.get(mid);
            if(violating < start){
                low = mid + 1;
            }else if(violating > end){
                high = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean ans[] = new boolean[queries.length];
        List<Integer> voilatingIndices = new ArrayList<>();
        for(int i=1; i<nums.length ;i++){
            if((nums[i]%2) == (nums[i-1]%2)){
                voilatingIndices.add(i);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int start= queries[i][0];
            int end= queries[i][1];
            if(binarySearch(start + 1, end , voilatingIndices)){
                ans[i] = false;
            }else{
                ans[i] = true;
            }
        }
        return ans;
    }
}