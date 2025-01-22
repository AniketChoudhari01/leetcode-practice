class Solution {
    class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] highestPeak(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int hgt[][] = new int[m][n];
        for (int arr[] : hgt) {
            Arrays.fill(arr, -1);
        }
        Queue<pair> q = new ArrayDeque<pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hgt[i][j] = 0;
                    q.add(new pair(i, j)); // intial sources
                }
            }
        }

        while (!q.isEmpty()) {
            pair curr = q.poll();
            int i = curr.x;
            int j = curr.y;
            int elem = hgt[i][j] + 1;
            if (j - 1 >= 0 && hgt[i][j - 1] == -1) {
                hgt[i][j - 1] = elem ;
                q.add(new pair(i, j-1));
            }
            if (i - 1 >= 0 && hgt[i - 1][j] == -1) {
                hgt[i-1][j ] = elem ;
                q.add(new pair(i-1, j));
            }
            if (j + 1 < n && hgt[i][j + 1] == -1) {
                hgt[i][j + 1] = elem ;
                q.add(new pair(i, j+1));
            }
            if (i + 1 < m && hgt[i + 1][j] == -1) {
                hgt[i+1][j ] = elem ;
                q.add(new pair(i+1, j));
            }
        }

        return hgt;
    }
}