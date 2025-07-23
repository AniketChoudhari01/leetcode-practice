class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        int sortedArr[] = new int[n];
        int highSquareIdx = n-1;
        while(left <= right){
            int num1 = nums[left]*nums[left];
            int num2 = nums[right]*nums[right];
            if(num1 > num2){
                sortedArr[highSquareIdx] = num1;
                left++;
            }else{
                sortedArr[highSquareIdx] = num2;
                right--;
            }
            highSquareIdx--;
        }
        return sortedArr;
    }
}