class Solution {
    public int maxSum(int[] nums) {
        //alll the elements in subarray are unique
        //the sum of elements in subarray is maximized.

        //step 1: need to find all the unique elements
        //step 2: delete the negative numbers
        //step 3: iterate and calculate the final answer
        //(1, 2, -1, -2, 1, 0, -1)
        //(1, 2, 0)
        int n = nums.length;
        boolean remove[] = new boolean[n];
        Set<Integer> set = new HashSet<>();
        int deleted = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || set.contains(nums[i])) {
                remove[i] = true;
                deleted++;
                continue;
            }
            set.add(nums[i]);
        }
        if (deleted == n) {//means all are either negative or repeat
            //find the among the array and return it
            int maxi = Integer.MIN_VALUE;
            for (int item : nums) {
                maxi = Math.max(maxi, item);
            }
            return maxi;
        } else if (deleted == 0) {//all unique
            int sum = 0;
            for (int item : nums) {
                sum += item;
            }
            return sum;
        } else if (deleted == n - 1) {//all are same elements
            int ans = 0;
            for(int i=0; i<n; i++){
                if(!remove[i]){
                    ans = nums[i];
                    break;
                }
            }
            return ans;
        } else {
            int sum = 0;
            //when delted some
            for (int i = 0; i < n; i++) {
                if (!remove[i]) {
                    sum += nums[i];
                }
            }
            return sum;
        }
        // System.out.println(Arrays.toString(remove));
        // return 0;
    }
}