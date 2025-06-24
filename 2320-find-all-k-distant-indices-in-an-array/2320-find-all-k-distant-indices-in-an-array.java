class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ansIdx = new ArrayList<>();
        boolean seen[]= new boolean[n];
        for(int i=0; i<n; i++){
            if(nums[i] == key){
                int j = (i - k >= 0 ? (i-k): 0);
                // System.out.println(j);
                while(j<=i+k && j<n){
                    if(!seen[j]){
                        ansIdx.add(j);
                        seen[j] = true;
                    }
                    j++;
                }
            }
        }
        return ansIdx;
    }
}