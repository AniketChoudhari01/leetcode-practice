class Solution {
    public int majorityElement(int[] nums) {

        //Moore's algorithm with count and element variables

        int count=0;
        int element=-1;

        for(int i=0;i<nums.length;i++){
            int curr_element=nums[i];
            if(count==0){
                element=curr_element;
                count=1;
            }else if(element==curr_element){
                count++;
            }else {
                count--;
            }
        }

        return element;

        // if(nums.length==1){
        //     return nums[0];
        // }
        
        // Arrays.sort(nums);
        // //n*log(n)

        // int n=nums.length;
        //  int cnt=1;
        // for(int i=0;i<n-1;i++){
           
        //     if(nums[i]==nums[i+1]){
        //         cnt++;

        //         if(cnt>Math.floor(n/2)){
        //             return nums[i];
        //         }
        //     }else{
        //         cnt=1;
        //     }
        // }

        // return -1;
    }
}