class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        //sliding window
        //from the start gap befor st and before end time
        //find the potential candiate to reschedule for a meeting
        //after that calculate the free time
        //using since the relative order is to be maintained then it should struck in mind for sliding window approach, for each k group of meetings we can push them at start and the difference will the totoal length - length of each meetings under that k meetings
        int maxFreeTime = 0;
        int start = 0;
        int n = startTime.length;
        int duration[] = new int[n];
        for(int i = 0; i<n; i++){
            duration[i] = endTime[i] - startTime[i];
        }
        for(int i = 0; i+k <= n; i++){
            int newEnd = (i + k < n ? startTime[i+k] : eventTime);
            int meetDuration = 0;//length of meet
            for(int j = i; j < i + k && j < n; j++){
                meetDuration += duration[j];
            }
            maxFreeTime = Math.max(maxFreeTime, newEnd - start - meetDuration);
            start = endTime[i];
        }
        return maxFreeTime;
    }
}