class Solution {

    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;// binary search on ans space
        long high = 1;
        for (int candy : candies) {
            high = Math.max(high, candy);
        }
        long low = 1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long cnt = 0;
            for (int candy : candies) {
                cnt += candy / mid;
            }
            if (cnt >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }
}