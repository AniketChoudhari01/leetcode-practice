class Solution {
    public long coloredCells(int n) {
        long ans = 1 + 2*((long)(n)*(n-1));
        return ans;
    }
}