class Solution {
    public int[][] merge(int[][] intervals) {

        int m = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < m; i++) {

            // // select an interval
            // if (/* !list.isEmpty() && */i<m && i!=1 && intervals[i][0] <= list.get(list.size() - 1).get(1)) {
            //     continue;
            // }

            if (list.get(list.size()-1).get(1) >= intervals[i][0]) {
                int end = Math.max(list.get(list.size()-1).get(1), intervals[i][1]);

                list.get(list.size()-1).set(1, end);
            } else {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }

            // for (int j = i + 1; j < m; j++) {
            // if (intervals[j][0] <= end) {
            // end = Math.max(end, intervals[j][1]);
            // }
            // }

            // list.add(Arrays.asList(start, end));

        }

        int mat[][] = new int[list.size()][2];

        int i = 0;
        while (i < list.size()) {
            mat[i][0] = list.get(i).get(0);
            mat[i][1] = list.get(i).get(1);
            i++;
        }

        return mat;
    }
}