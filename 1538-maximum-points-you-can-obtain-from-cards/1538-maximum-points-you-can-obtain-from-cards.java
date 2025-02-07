class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int leftWindow = 0, rightWindow = 0;
        for (int i = 0; i < k; i++) {
            leftWindow += cardPoints[i];
        }
        int maxi = leftWindow;
        int left = k-1, right = n - 1;
        while (left >= 0 && right >= n - k) {
            leftWindow -= cardPoints[left--];
            rightWindow += cardPoints[right--];
            // System.out.println(leftWindow+" , "+rightWindow);
            maxi = Math.max(maxi, (leftWindow + rightWindow));
        }
        return maxi;
    }
}