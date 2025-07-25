class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        //2 pointers approach
        int right = arr.length-1;
        while(right >0 && arr[right] >= arr[right-1]){
            right--;
        }//find the right most index from there till the end array is increasing
        int ans = right;
        int left = 0;
        while(left < right && (left == 0 || arr[left] >= arr[left-1])){
            while(right < arr.length && arr[left] > arr[right]){
                right++;
            }
            ans = Math.min(ans, right-left-1);
            left++;
        }
        return ans;
    }
}