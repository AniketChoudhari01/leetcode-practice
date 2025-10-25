class Solution {
    private void reverse(int nums[], int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int idx = -1, n = nums.length;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        } //find the longest prefix where it is matching that is all the elements are same
          //by travel from start and find the first idx where the curr > next
          //by this we will find the longest common prefix that matches 
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            // System.out.println(Arrays.toString(nums));
        } else {
            //if we don't find anything that is the given element is all reverseed desc order then we have to return the all the elements in reverseed order 
            //use: we can use inbuilt or 2 ptrs

            //step 2: now travel from the right side before the found idx and break for the first digit
            //who is just smallest and greater than element at current idx
            //find the just larger element
            for (int i = n - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    int temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            //step4: reverse from idx+1 till end of the array in asecding order
            reverse(nums, idx + 1, n - 1);
        }
    }
}
