class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int minCandies = 0;
        int candiesDist[] = new int[n];
        Arrays.fill(candiesDist, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candiesDist[i] = candiesDist[i-1] + 1;
            }
        }
        for(int i= n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candiesDist[i] = Math.max(candiesDist[i], candiesDist[i+1] + 1);
            }
        }
        for(int candy: candiesDist){
            minCandies += candy;
        }
        return minCandies;
    }
}