class Solution {
    private boolean validIdx(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        return true;
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int efforts[][] = new int[m][n];
        int maxi = (int) 1e9;
        for (int effort[] : efforts) {
            Arrays.fill(effort, maxi);
        }
        efforts[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));//dijikstras
        q.offer(new int[] { 0, 0, 0 });
        int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int item[] = q.poll();
            int dist = item[0];
            int i = item[1];
            int j = item[2];
            if (i == m - 1 && j == n - 1) {
                return dist;
            }
            for (int dir[] : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (validIdx(x, y, m, n)) {
                    int newEffort = Math.max(efforts[i][j], Math.abs(heights[i][j] - heights[x][y]));
                    if(newEffort < efforts[x][y]){
                        efforts[x][y] = newEffort;
                        q.offer(new int[]{newEffort, x, y});
                    }
                }
            }
        }
        return 0;
    }
}