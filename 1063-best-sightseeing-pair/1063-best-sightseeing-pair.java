class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxLeftScore[] = new int[values.length];
        maxLeftScore[0] = values[0];
        for(int i=1; i<values.length; i++){
            int currRightScore = values[i] - i;
            maxScore = Math.max(maxScore, maxLeftScore[i-1] + currRightScore);
            int currLeftScore = values[i] + i;
            maxLeftScore[i] = Math.max(maxLeftScore[i-1], currLeftScore);
        }
        return maxScore;
    }
}