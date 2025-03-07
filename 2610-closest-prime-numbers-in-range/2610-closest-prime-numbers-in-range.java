class Solution {
    static final int MAX = (int)1e6 + 1;
    static final boolean seive[] = new boolean[MAX];
    static{
        seive[1] = true;
        for(int i = 2; i< seive.length; i++){
            if(!seive[i]){
                for(long j = (long)i*i; j<seive.length; j += i){
                    seive[(int)j] = true;
                }
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        int ans[] = {-1, -1};
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        for(int i = left ; i<= right; i++){
            if(!seive[i]){
                if(prev != -1 && (i-prev)<minDiff){
                    minDiff = i- prev;
                    ans[0] = prev;
                    ans[1] = i;
                }
                prev = i;
            }
        }
        return ans;
    }
}