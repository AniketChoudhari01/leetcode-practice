class Solution {
    private boolean canWeRepair(int ranks[], int cars, long k){
        long cnt = 0;
        for(int r: ranks){
            cnt += Math.sqrt(k/r);
            if(cnt >= cars){
                return true;
            }
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long high = 1;
        for(int i=0; i<n; i++){
            high = Math.max(high, ranks[i]);
        }
        high = high*cars*cars;
        System.out.println(high);
        long low = 1;
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(canWeRepair(ranks, cars, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}