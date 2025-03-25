class Solution {
    private boolean canSlice(int range[][]){
        Arrays.sort(range, (a,b)-> Integer.compare(a[0], b[0]));
        int prev = range[0][1];
        int merged_range = 1;
        for(int i=1; i<range.length; i++){
            if(prev <= range[i][0]){
                merged_range++;
            }
            prev = Math.max(prev, range[i][1]);
        }
        return merged_range >= 3;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int N = rectangles.length;
        int start[][] = new int[N][2];
        int end[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            start[i][0] = rectangles[i][0];
            start[i][1] = rectangles[i][2];
            end[i][0] = rectangles[i][1];
            end[i][1] = rectangles[i][3];
        }
        // Arrays.sort(start,
        //         (a, b) -> {
        //             if (a[0] == b[0]) {
        //                 return Integer.compare(a[1], b[1]);
        //             } else {
        //                 return Integer.compare(a[0], b[0]);
        //             }
        //         });
        // // for (int a[] : start) {
        // //     System.out.println(Arrays.toString(a));
        // // }
        // Arrays.sort(end,
        //         (a, b) -> {
        //             if (a[0] == b[0]) {
        //                 return Integer.compare(a[1], b[1]);
        //             } else {
        //                 return Integer.compare(a[0], b[0]);
        //             }
        //         });

        // int lx = start[0][0];
        // int rx = start[0][1];
        // int ly = end[0][0];
        // // int ry = end[0][1];
        // int cnt_merged_x = 1;
        // int cnt_merged_y = 1;
        // for (int i = 1; i < rectangles.length; i++) {
        //     int l1 = start[i][0];
        //     int r1 = start[i][1];
        //     int l2 = end[i][0];
        //     int r2 = end[i][1];
        //     // logic for x path
        //     if (l1 < rx) {
        //         if (r1 > rx) {
        //             rx = r1;
        //             // System.out.println(" l1, r1 "+l1+" , "+r1);
        //         }
        //     } else {
        //         cnt_merged_x++;
        //         lx = l1;
        //         rx = r1;
        //     }
        //     // System.out.println(lx + " " + rx);
        //     if (l2 < ry) {
        //         if (r2 > ry) {
        //             ry = r2;
        //         }
        //     } else {
        //         cnt_merged_y++;
        //         ly = l2;
        //         ry = r2;
        //     }
        // }
        // System.out.println(cnt_merged_x + " , " + cnt_merged_y);
        return (canSlice(start) || canSlice(end));
    }
}