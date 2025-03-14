class Solution {
    long maxi ;
    private boolean isSufficient(long k, long mid, int candies[]){
        long cnt = 0;
        for(int candy: candies){
            cnt += candy / mid;
        }
        return cnt >= k;
    }
    private int binarySearchOnAnsSpace(long low, long high, long k, int candies[]){
        if(low > high) return (int)high;
        long mid = low + (high-low)/2;
        if(isSufficient(k, mid, candies)){
            return binarySearchOnAnsSpace(mid + 1, high, k, candies);
        }else{
            return binarySearchOnAnsSpace(low, mid - 1, k, candies);
        }
    }
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;//binary search on ans space
        long maxi = Integer.MIN_VALUE;
        for(int candy: candies){
            maxi = Math.max(maxi, candy);
        }
        return binarySearchOnAnsSpace(1, maxi, k, candies);
    }
}