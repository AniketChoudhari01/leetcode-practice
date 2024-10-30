class Solution {

    private int binarySearch(int temp[], int low, int high, int element, int ans) {
        if (low > high) {
            return ans;
        }
        int mid = low + (high - low) / 2;
        if(temp[mid]==element){ //import if there are duplicates
            return mid;
        }
        else if (temp[mid] < element) {
            return binarySearch(temp, mid + 1, high, element, ans);
        } else {
            ans=mid;
            return binarySearch(temp, low, mid - 1, element, ans);
        }
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int temp[] = new int[n];
        int j = 0;
        int ans=-1;
        for (int i = 0; i < n; i++) {
            int idx = binarySearch(temp, 0, j - 1, nums[i], ans);
            if (idx == -1) {
                temp[j++] = nums[i];
            } else {
                temp[idx] = nums[i];
            }
        }
        return j;
    }
}