class Solution {
    public int numOfSubarrays(int[] arr) {
        int ans  = 0;
        int n = arr.length;
        int MOD = (int)1e9+7;
        int[] dpEven = new int[n], dpOdd = new int[n];
        for(int i=0; i<n; i++){
            arr[i] %= 2;
        }
        if(arr[n-1]==1){
            dpOdd[n-1] = 1;
        }else{
            dpEven[n-1] = 1;
        }
        for(int i= n-2; i>=0; i--){
            if(arr[i] == 1){
                dpOdd[i] = (1 + dpEven[i+1])%MOD;
                dpEven[i] = dpOdd[i+1];
            }else{
                dpEven[i] = (1+ dpEven[i+1])%MOD;
                dpOdd[i] = dpOdd[i+1];
            }
        }
        for(int num: dpOdd){
            ans = (ans + num)%MOD;
        }
        return ans;
    }
}