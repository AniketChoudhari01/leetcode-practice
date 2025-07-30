class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while(i < n){
            int j = nums[i]-1;
            if(nums[i] != nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
            }
        }
        for(int k=0; k<n; k++){
            if(nums[k] != k+1){
                ansList.add(nums[k]);
            }
        }
        return ansList;
    }
}