class Solution {
    public int maxFreeTime(int eventTime, int k, int[] st, int[] et) {
        int n = st.length;
        int duration[] = new int[n];
        for(int i=0; i<n; i++){
            duration[i] = et[i]-st[i];
        }
        int maxGap = 0;
        for(int i=0; i+k <= n; i++){
            int len = 0;
            int start = 0;
            int end = eventTime;
            for(int j=i; j<i+k; j++){
                len += duration[j];
            }
            if(i!=0){
                start = et[i-1];
            }
            if(i+k-1 != n-1){
                end = st[i+k];
            }
            int gap = end - start - len;
            maxGap = Math.max(maxGap, gap);
        }
        return maxGap;
    }
}