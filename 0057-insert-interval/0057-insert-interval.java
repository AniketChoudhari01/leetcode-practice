class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int arr[][] = new int[n+1][2];
        boolean isAdded;
        for(int i=0; i<n; i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }        
        arr[n][0] = newInterval[0];
        arr[n][1] = newInterval[1];
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        list.add(arr[0]);
        for(int i=1; i<n+1; i++){
            int len = list.size();
            if(list.get(len - 1)[1] >= arr[i][0] ){
                list.get(len-1)[1] = Math.max(list.get(len-1)[1], arr[i][1]);
            }else{
                list.add(arr[i]);
            }
        }
        int res[][] = new int[list.size()][2];
        int i = 0;
        for(int temp[]: list){
            res[i][0] = temp[0];
            res[i++][1] = temp[1];
        }
        return res;
    }
}