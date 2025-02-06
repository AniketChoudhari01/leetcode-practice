class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int maxi = 0;
        int prefixSum[] = new int[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += cardPoints[i];
            prefixSum[i] = temp;
        }
        if (n == k)
            return temp;
        for (int left = n - k, it = 0; it <= k; left = (left + 1) % n, it++) {
            int total = temp - prefixSum[(left - 1 + n) % n];
            int rem = k;
            if (left != 0) {
                rem = k - (n - left);
            }
            if (rem > 0) {
                total += prefixSum[(rem - 1 + n) % n];
            }
            maxi = Math.max(maxi, total);
        }
        return maxi;
    }
}