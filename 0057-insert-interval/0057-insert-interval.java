class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int temp[][] = new int[m+1][2];
        int i=0;
        for(int inter[]:intervals){
            temp[i][0] = inter[0];
            temp[i++][1] = inter[1];
        }
        temp[m][0] = newInterval[0];
        temp[m][1] = newInterval[1];
        Arrays.sort(temp, (a,b)->Integer.compare(a[0], b[0]));
        int ans[][] = new int[m+1][2];
        ans[0][0] = temp[0][0];
        ans[0][1] = temp[0][1];
        int idx =0;
        for(int j=1; j<m+1; j++){
            if(ans[idx][1] >= temp[j][0]){
                ans[idx][1] = Math.max(ans[idx][1], temp[j][1]);
            }else{
                ans[++idx][0] = temp[j][0];
                ans[idx][1] = temp[j][1];
            }
        }
        return Arrays.copyOfRange(ans, 0, idx+1);
    }
}