class Solution {
public:
    long long bowlSubarrays(vector<int>& nums) {
        //the logic is for every index we have to check if it can be the lowest element of bowl
        //using prefix max and suffix max we can find out
        //for every index i, we can check if there exist any prev max element at index i-2 and similarly 
        //i+2 in the right side of the array
        //[2,5,3,1,4]
        //prefix max [2, 5, 5 , 5, 5]
        //suffix max[5 , 5,4 , 4 , 4]
        //2 x
        //5 x
        //3 x
        //cnt = 1, 1
        //cnt = 1, 4
        //(2,5,3,1,7,8,9)
        //pref(2,5,5,5,7,8,9) : (9 ,9,9 ,9 ,9, 9,9) 
        //2 -> 1,
        //5 -> 1
        //3 ->1
        // 1<- 1->1
        // 7 -> 1
        int n = nums.size();
        vector<int> prefixMax(n, 0), suffixMax(n, 0);
        prefixMax[0] = nums[0];
        suffixMax[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            prefixMax[i] = max(prefixMax[i-1], nums[i]);
            suffixMax[n-i-1] = max(suffixMax[n-i], nums[n-i-1]);
        }
        suffixMax[0] = max(suffixMax[0], nums[0]);
        int cnt = 0;
        for(int i = 1; i<n-1; i++){
            if(prefixMax[i-1] > nums[i] && nums[i] < suffixMax[i+1]){
                cnt++;
            }
        }
        return cnt;
    }
};