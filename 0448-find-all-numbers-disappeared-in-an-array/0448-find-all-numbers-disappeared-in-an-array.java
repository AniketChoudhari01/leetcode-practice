class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int n = nums.length;
        //performing cycling sort
        int i=0;
        while(i < n){
            int j = nums[i]-1;
            if(nums[i] != nums[j]){
                //swap both of them
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
            }
        }
        for(int j=0; j<n; j++){
            if(nums[j] != j+1){
                ansList.add(j+1);
            }
        }
        return ansList;
    }
}