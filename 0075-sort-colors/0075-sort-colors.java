class Solution {
    private void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length-1;
        while(mid <= right){
            if(nums[mid] == 2){
                swap(mid, right, nums);
                right--;
            }else if(nums[mid] == 0){
                swap(mid, left, nums);
                left++;
                mid++;
            }else{
                //do nothing
                mid++;
            }
        }
    }
}