class Solution {
    // private int hepler(int nums[], int curr, int startIdx){
    //     int len = 1;
    //     for(int i = startIdx+1; i<nums.length; i++){
    //         int elem = nums[i];
    //         if(curr != elem){
    //             len++;
    //             curr = elem;
    //         }
    //     }
    //     return len;
    // }
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int cnt1s = 0, cnt0s = 0;
        int parity[] = new int[2];
        // int firstZeroIdx = -1;
        // int firstOneIdx = -1;
        for(int i=0; i<n; i++){
            int num = nums[i] % 2;
            if(num == 0){
                cnt0s++;
            }else{
                // if(firstOneIdx == -1){
                //     firstOneIdx = i;
                // }
                cnt1s++;
            }
            parity[num] = parity[1 - num] + 1; 
        }
        // System.out.println(Arrays.toString(nums));
        // int pickZeroStart = hepler(nums, 0, firstZeroIdx);
        // int pickOneStart = hepler(nums, 1, firstOneIdx);
        // System.out.println("zero "+pickZeroStart+ " one "+pickOneStart);
        int maxi = Math.max(Math.max(cnt1s, cnt0s), Math.max(parity[0], parity[1]));
        return maxi;
    }
}