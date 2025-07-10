class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        //the problem asks us if we can shift the current interval in left or right  if there is space available
        //case1: when the is a space available either max(left available spaces) or the max(right available spaces)
        //then we can shift the current interval there
        //for current the answer will the left adj gap + right adj gap + interval
        //case 2: when there is no space available then we can shift is either left space or right adj space and 
        //and our answer will be the max of both cases when considered
        int n = startTime.length;
        boolean canBeShifted[] = new boolean[n];
        int leftGap = 0, rightGap = 0;
        for(int i=0; i<n; i++){
            if(leftGap >= (endTime[i] - startTime[i])){
                canBeShifted[i] = true;
            }
            leftGap = Math.max(leftGap, startTime[i] - (i == 0 ? 0 : endTime[i-1]));
            if(rightGap >= (endTime[n-i-1] - startTime[n-i-1])){
                canBeShifted[n-i-1] = true;
            }
            rightGap = Math.max(rightGap, (i == 0 ? eventTime : startTime[n-i]) - endTime[n-i-1]);
        }
        int maxFreeTime = 0;
        for(int i=0; i<n; i++){
            int left = (i == 0 ? 0 : endTime[i-1]);
            int right = (i == n-1 ? eventTime : startTime[i+1]);
            if(canBeShifted[i]){
                maxFreeTime = Math.max(maxFreeTime, right - left);//when can be shifted
            }else{
                maxFreeTime = Math.max(maxFreeTime, right - left - (endTime[i] - startTime[i]));
            }
        }
        return maxFreeTime;
    }
}