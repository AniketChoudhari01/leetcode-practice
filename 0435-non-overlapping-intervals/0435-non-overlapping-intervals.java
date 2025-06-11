class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cntOvlp = 0;
        int prev = 0, curr = 1, n = intervals.length;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1], b[1]));
        for(int a[]:intervals){
            System.out.println(Arrays.toString(a));
        }
        while (curr < n) {
            if(intervals[prev][1] > intervals[curr][0]){
                cntOvlp++;
            }else{
                prev = curr;
            }
            curr++;
        }
        return cntOvlp;
    }
}