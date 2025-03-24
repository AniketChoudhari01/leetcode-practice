class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        // for (int arr[] : meetings) {
        //     System.out.println(Arrays.toString(arr));
        // }
        List<int[]> intervals = new ArrayList<>();
        int meeting_days = 0;
        intervals.add(new int[] { meetings[0][0], meetings[0][1] });
        for (int i = 1; i < meetings.length; i++) {
            int meet[] = intervals.get(intervals.size() - 1);
            int l1 = meet[0];
            int r1 = meet[1];
            int l2 = meetings[i][0];
            int r2 = meetings[i][1];
            // ovelaps
            if (l2 <= r1) {
                if (r1 <= r2) {
                    intervals.get(intervals.size()-1)[1] = r2;
                }
            } else {
                intervals.add(new int[]{l2, r2});
            }
        }
        for(int a[]: intervals){
            meeting_days += (a[1]-a[0] + 1);
            // System.out.println(meeting_days);
        }
        // System.out.println(meeting_days);
        return (days - meeting_days);
    }
}