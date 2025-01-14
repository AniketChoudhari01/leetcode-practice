class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int cmnPrefix[] = new int[n];
        int freq[] = new int[n + 1];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
            freq[B[i]]++;
            if (A[i] == B[i]) {
                cnt++;
            } else {
                if (freq[A[i]] == 2) {
                    cnt++;
                }
                if (freq[B[i]] == 2) {
                    cnt++;
                }
            }
            cmnPrefix[i] = cnt;
        }
        return cmnPrefix;
    }
}