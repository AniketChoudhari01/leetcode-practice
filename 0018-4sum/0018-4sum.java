class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ansList = new ArrayList<>();
        for(int i=0; i<n-3; i++){
            if(i != 0 && nums[i-1] == nums[i]) continue;
            for(int j=i+1; j<n-2; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = n-1;
                while(left < right){
                    long sum = (long)nums[left]+(long)nums[right]+(long)nums[i]+(long)nums[j];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        ansList.add(new ArrayList<>(list));
                        left++;
                        right--;
                        // System.out.println(i);
                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }    
                }
            }
        }
        return ansList;
    }
}